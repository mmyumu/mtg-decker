package com.mmyumu.magictome.wizard.update;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.check.IListModelCheckListener;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.check.ListModelCheck;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.ui.IListModelPart;

/**
 * The class to manage the view of the Sets Selection Part
 * 
 * @author mmyumu
 * 
 */
public class SetsSelectionPart implements IListModelCheckListener,
		IListModelPart<ListModelCheck> {
	/**
	 * ID of the part
	 */
	public static final String ID = "com.mmyumu.magictome.wizard.update.setsselectionpart";
	/**
	 * The TableViewer to display the Sets
	 */
	private CheckboxTableViewer viewer;

	/**
	 * Model of the Update Status Bar
	 */
	private SetsModel model;

	/**
	 * The Select/Unselect all item
	 */
	private MDirectToolItem selectAllItem;

	/**
	 * The associated part
	 */
	private MPart part;

	@Inject
	public SetsSelectionPart(MPart part, Logger logger, Composite parent,
			EModelService modelService, MApplication application,
			EHandlerService handlerService, ECommandService commandService,
			MWindow window) {
		this.part = part;
		// Initializes model
		model = ModelProvider.getModel(ID, SetsModel.class);
		model.addListener(this);

		MToolBar toolbar = MMenuFactory.INSTANCE.createToolBar();
		part.setToolbar(toolbar);

		// Update hander of the selectAll command
		computeAllSelectionHandler();

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
	}

	/**
	 * Creates the CheckboxTableViewer
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	private void createViewer(Composite parent) {
		viewer = CheckboxTableViewer.newCheckList(parent, SWT.SINGLE
				| SWT.BORDER | SWT.FULL_SELECTION);
		viewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				SetEx set = (SetEx) event.getElement();
				List<IModelCheckElement> toBeToggled = new ArrayList<IModelCheckElement>();
				toBeToggled.add(set);
				model.toggleElements(toBeToggled);
			}
		});

		createColumns(parent, viewer);

		final Table table = viewer.getTable();
		table.setHeaderVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());

		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.heightHint = 200;
		viewer.getControl().setLayoutData(gridData);

		viewer.setCheckStateProvider(new ICheckStateProvider() {
			@Override
			public boolean isGrayed(Object element) {
				return false;
			}

			@Override
			public boolean isChecked(Object element) {
				SetEx set = (SetEx) element;
				return set.isUsed();
			}
		});
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
		String[] titles = { "D/L", "Code", "Name" };
		int[] bounds = { 20, 20, 80 };

		TableViewerColumn col;

		// First column is for the checkbox
		col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.getColumn().setWidth(35);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return "";
			}
		});

		// Second column is for the extension's code
		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetEx setEx = (SetEx) element;
				return setEx.getCode();
			}
		});

		// Third column is for the extension's code
		col = createTableViewerColumn(titles[2], bounds[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetEx setEx = (SetEx) element;
				return setEx.getName();
			}
		});

		// Create the cell editors
		CellEditor[] editors = new CellEditor[titles.length];

		// Column 1 : Completed (Checkbox)
		editors[0] = new CheckboxCellEditor(table);
		editors[1] = new TextCellEditor(table);
		editors[2] = new TextCellEditor(table);

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
				SWT.CHECK);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	/**
	 * Packs the columns of the table viewer
	 */
	public void packTable() {
		TableColumn[] columns = viewer.getTable().getColumns();
		for (int i = 1; i < columns.length; i++) {
			columns[i].pack();
		}
		// for (TableColumn column : columns) {
		// column.pack();
		// }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsChecked(List<IModelCheckElement> elements) {
		elementsCheckStateChanged(elements);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsUnchecked(List<IModelCheckElement> elements) {
		elementsCheckStateChanged(elements);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsToggled(List<IModelCheckElement> elements) {
		elementsCheckStateChanged(elements);
	}

	/**
	 * Fired if the check state of some elements are changed
	 * 
	 * @param elements
	 *            the elements which have check state modified
	 */
	private void elementsCheckStateChanged(List<IModelCheckElement> elements) {
		for (IModelCheckElement elt : elements) {
			viewer.setChecked(elt, elt.isChecked());
		}
		// Update hander of the selectAll command
		computeAllSelectionHandler();
	}

	/**
	 * Computes if SelectAllHandler or UnselectAllHandler is handling the
	 * selectAll command
	 */
	private void computeAllSelectionHandler() {
		boolean selectAll = false;
		for (IModelCheckElement elt : model.getElements()) {
			if (!elt.isChecked()) {
				selectAll = true;
				break;
			}
		}

		if (selectAllItem != null) {
			selectAllItem.setVisible(false);
			part.getToolbar().getChildren().remove(selectAllItem);
		}
		if (selectAll) {
			selectAllItem = buildSelectAllItem(
					"bundleclass://com.mmyumu.magic-tome/com.mmyumu.magictome.handlers.SelectAllHandler",
					"Select all");
		} else {
			selectAllItem = buildSelectAllItem(
					"bundleclass://com.mmyumu.magic-tome/com.mmyumu.magictome.handlers.UnselectAllHandler",
					"Unselect all");
		}
		part.getToolbar().getChildren().add(selectAllItem);
	}

	/**
	 * Builds a MDirectToolItem for select/unselect all
	 * 
	 * @param bundleclass
	 *            the bundleclass of the Handler
	 * @param tooltip
	 *            the tooltip of the item
	 * @return the created MDirectToolItem
	 */
	private MDirectToolItem buildSelectAllItem(String bundleclass,
			String tooltip) {
		MDirectToolItem selectAllItem = MMenuFactory.INSTANCE
				.createDirectToolItem();
		selectAllItem
				.setElementId("com.mmyumu.magictome.wizard.update.setsselectionpart.toolbar.selectall");
		selectAllItem
				.setIconURI("platform:/plugin/com.mmyumu.magic-tome/icons/all_instances_16x16.gif");
		selectAllItem.setTooltip(tooltip);
		selectAllItem.setContributionURI(bundleclass);
		selectAllItem.setVisible(true);
		selectAllItem.setEnabled(true);
		return selectAllItem;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsAdded(List<? extends IModelElement> elements) {
		if ((viewer != null) && !viewer.getControl().isDisposed()) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					viewer.refresh();
					packTable();

					// Update hander of the selectAll command
					computeAllSelectionHandler();
				}
			});
		}
	}

	@Override
	public void elementsRemoved(List<? extends IModelElement> elements,
			int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public ListModelCheck getModel() {
		return model;
	}
}
