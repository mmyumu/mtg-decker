package com.mmyumu.magictome.ui.sets;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.mmyumu.magictome.model.IListModelListener;
import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.params.AppParams;
import com.mmyumu.magictome.rmi.api.Api;
import com.mmyumu.magictome.rmi.server.ApiImpl;
import com.mmyumu.magictome.rmi.server.Server;

/**
 * The class to manage the view of the Set Part
 * 
 * @author mmyumu
 * 
 */
public class SetsPart implements IListModelListener {
	/**
	 * The ID of the part
	 */
	public static String ID;

	/**
	 * The TableViewer to display Sets
	 */
	private TableViewer viewer;

	/**
	 * The part
	 */
	@Inject
	private MPart part;

	/**
	 * The logger
	 */
	@Inject
	private Logger logger;

	/**
	 * The model containing the sets
	 */
	private SetsModel model;

	private class RMIThread extends Thread {
		public void run() {
			try {
				Server.startRegistry();
				Server.registerObject(Api.class.getSimpleName(), new ApiImpl());
				Thread.sleep(5 * 60 * 1000);

			} catch (RemoteException e) {
				logger.error(e, "Exception RMI");
			} catch (AlreadyBoundException e) {
				logger.error(e, "Already bound");
			} catch (InterruptedException e) {
				logger.error(e, "Exception interrupted");
			}
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param part
	 *            The current view
	 * @param logger
	 *            The logger
	 * @param parent
	 *            The parent composite
	 */
	@Inject
	public SetsPart(MPart part, Logger logger, Composite parent,
			EModelService modelService, MApplication application) {
		// Initializes model
		ID = part.getElementId();
		model = ModelProvider.getModel(AppParams.ID, MtgDatabaseModel.class)
				.getSetsModel();
		model.addListener(this);

		// Initializes layout
		if (parent.getLayout() == null)
			parent.setLayout(new FillLayout());

		// Creates composite
		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout());

		// Creates viewer
		createViewer(composite);
		viewer.setInput(model.getElements());

		packTable();

		// RMI
		new RMIThread().start();
	}

	/**
	 * Creates the TableViewer
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	private void createViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.NONE);

		// Get the content for the viewer, setInput will call getElements in the
		// contentProvider

		createColumns(parent, viewer);

		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());

		// Layout the viewer
		// TableLayout tlayout = new TableLayout();
		// tlayout.addColumnData(new ColumnPixelData(20, false));
		// tlayout.addColumnData(new ColumnWeightData(20, 30, true));
		// tlayout.addColumnData(new ColumnWeightData(80, 80, true));
		// viewer.getTable().setLayout(tlayout);
		//
		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		viewer.getControl().setLayoutData(gridData);
	}

	/**
	 * Creates the columns for the table
	 * 
	 * @param parent
	 *            the parent Composite
	 * @param viewer
	 *            the viewer to add the columns into
	 */
	private void createColumns(final Composite parent, final TableViewer viewer) {
		Table table = viewer.getTable();
		String[] titles = { "Code", "Name" };
		int[] bounds = { 20, 80 };

		TableViewerColumn col;

		// Second column is for the extension's code
		col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetEx setEx = (SetEx) element;
				return setEx.getCode();
			}
		});

		// Third column is for the extension's code
		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetEx setEx = (SetEx) element;
				return setEx.getName();
			}
		});

		// Create the cell editors
		CellEditor[] editors = new CellEditor[titles.length];

		editors[0] = new TextCellEditor(table);
		editors[1] = new TextCellEditor(table);

		// Assign the cell editors to the viewer
		viewer.setColumnProperties(titles);
		viewer.setCellEditors(editors);
		viewer.setCellModifier(new ICellModifier() {

			@Override
			public void modify(Object element, String property, Object value) {
			}

			@Override
			public Object getValue(Object element, String property) {
				return null;
			}

			@Override
			public boolean canModify(Object element, String property) {
				return false;
			}
		});
	}

	/**
	 * Creates the column with the specified parameters
	 * 
	 * @param title
	 *            the name/header of the column
	 * @param bound
	 *            the width of the column
	 * @param colNumber
	 *            the index of the column
	 * @return the created TableViewerColumn
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @return the viewer
	 */
	public TableViewer getViewer() {
		return viewer;
	}

	@Override
	public void elementsAdded(List<? extends IModelElement> elements) {
		viewer.refresh();
		packTable();
	}

	@Override
	public void elementsRemoved(List<? extends IModelElement> elements,
			int index) {
		// TODO Auto-generated method stub

	}

	/**
	 * Packs the columns of the table viewer
	 */
	public void packTable() {
		TableColumn[] columns = viewer.getTable().getColumns();
		for (TableColumn column : columns) {
			column.pack();
		}
	}
}