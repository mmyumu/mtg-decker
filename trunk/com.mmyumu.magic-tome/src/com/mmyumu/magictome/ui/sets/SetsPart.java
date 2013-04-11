package com.mmyumu.magictome.ui.sets;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.mmyumu.magictome.AppLifecycle;
import com.mmyumu.magictome.events.EventConstants;
import com.mmyumu.magictome.handlers.SelectAllHandler;
import com.mmyumu.magictome.handlers.UnselectAllHandler;
import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.check.IListModelCheckListener;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.check.ListModelCheck;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.params.AppParams;
import com.mmyumu.magictome.ui.IListModelPart;

/**
 * The class to manage the view of the Set Part
 * 
 * @author mmyumu
 * 
 */
public class SetsPart implements IListModelCheckListener,
		IListModelPart<ListModelCheck> {

	/** The ID of the part. */
	public static String ID;

	/** The TableViewer to display the Sets. */
	private CheckboxTableViewer viewer;

	/** The part. */
	@Inject
	private MPart part;

	/** The logger. */
	@Inject
	private Logger logger;

	/** The global Model. */
	private MtgDatabaseModel mtgModel;

	/** The Model containing the sets. */
	private SetsModel model;

	/** The select/unselect all item from the toolbar. */
	private MHandledToolItem selectAllItem;

	/** The Handler Service. */
	@Inject
	private EHandlerService handlerService;

	/** Container of the Part. */
	private Composite container;

	/** Parent Composite. */
	private Composite parent;

	/** Tells whether the model is empty or not. */
	private boolean empty;

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
			EModelService modelService, MApplication application,
			EHandlerService handlerService, ECommandService commandService) {
		// Initializes model
		ID = part.getElementId();
		this.parent = parent;
		this.handlerService = handlerService;
		mtgModel = ModelProvider.getModel(AppParams.ID, MtgDatabaseModel.class);
		model = ModelProvider.getModel(ID, SetsModel.class);
		model.addListener(this);

		model.addElements(mtgModel.getSetsModel().getElements());

		empty = true;

		// Get item from toolbar
		List<MHandledToolItem> findElements = modelService.findElements(
				part.getToolbar(),
				"com.mmyumu.magic-tome.deckeditor.sets.toolbar.selectAll",
				MHandledToolItem.class, null);
		selectAllItem = findElements.get(0);

		buildPart();
	}

	private void buildContainer() {
		if (container != null) {
			container.dispose();
		}
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
	}

	private void buildPart() {
		if (model.getElements().isEmpty()) {
			buildEmptyPart();
			empty = true;
		} else {
			if (empty) {
				handlerService.activateHandler(
						"com.mmyumu.magictome.handler.selectAll",
						new UnselectAllHandler());
				buildNotEmptyPart();
				empty = false;
			}
		}
		parent.layout();
	}

	private void buildEmptyPart() {
		buildContainer();

		StyledText text = new StyledText(container, SWT.WRAP);
		text.setEditable(false);
		text.setCaret(null);
		text.setText("No sets in the database. Use the Update database button to download the available sets.");
		text.setCursor(new Cursor(container.getDisplay(), SWT.CURSOR_ARROW));
		StyleRange style1 = new StyleRange();
		style1.fontStyle = SWT.ITALIC;
		style1.start = 0;
		style1.length = text.getText().length();
		text.setStyleRange(style1);
	}

	private void buildNotEmptyPart() {
		buildContainer();

		// Creates composite
		Composite composite = new Composite(container, SWT.BORDER);
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
		table.setLinesVisible(true);

		viewer.setContentProvider(new ArrayContentProvider());

		GridData gridData = new GridData();
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
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

		viewer.setSorter(new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if ((e1 instanceof SetEx) && (e2 instanceof SetEx)) {
					SetEx set1 = (SetEx) e1;
					SetEx set2 = (SetEx) e2;

					return set1.getName().compareTo(set2.getName());
				}
				return super.compare(viewer, e1, e2);
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
		String[] titles = { "Use", "Code", "Name" };
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
	 * Passing the focus request to the viewer's control.
	 */

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @return the viewer
	 */
	public CheckboxTableViewer getViewer() {
		return viewer;
	}

	@Override
	public void elementsAdded(List<? extends IModelElement> elements) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				buildPart();

				viewer.refresh();
				packTable();

				// Update hander of the selectAll command
				computeAllSelectionHandler();
			}
		});
	}

	@Override
	public void elementsRemoved(List<? extends IModelElement> elements,
			int index) {
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
		selectAllItem.setTooltip("Unselect all");
		boolean selectAll = false;
		// selectAllItem.
		for (IModelCheckElement elt : model.getElements()) {
			if (!elt.isChecked()) {
				selectAll = true;
				selectAllItem.setTooltip("Select all");
				break;
			}
		}
		if (selectAll) {
			handlerService.activateHandler(
					"com.mmyumu.magictome.commands.selectAll",
					new SelectAllHandler());
		} else {
			handlerService.activateHandler(
					"com.mmyumu.magictome.commands.selectAll",
					new UnselectAllHandler());
		}
	}

	@Override
	public ListModelCheck getModel() {
		return model;
	}

	/**
	 * Fired when the cards download is done
	 * 
	 * @param event
	 *            The Job Change Event
	 */
	@Inject
	@Optional
	public void getEvent(
			@UIEventTopic(EventConstants.EVENT_UPDATE_CARDS_DONE) IJobChangeEvent event) {
		AppLifecycle.save();
		model.removeElements(model.getElements());
		model.addElements(mtgModel.getSetsModel().getElements());
	}
}