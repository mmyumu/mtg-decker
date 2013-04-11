package com.mmyumu.magictome.ui.database.browser;

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
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
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
import com.mmyumu.magictome.model.IListModelListener;
import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.card.CardEx;
import com.mmyumu.magictome.model.card.CardsModel;
import com.mmyumu.magictome.model.check.IListModelCheckListener;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.params.AppParams;

/**
 * The class to manage the view of the Set Part
 * 
 * @author mmyumu
 * 
 */
public class DatabaseBrowserPart implements IListModelListener,
		IListModelCheckListener {
	/**
	 * The ID of the part
	 */
	public static String ID;

	/**
	 * The TableViewer to display the Sets
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
	 * The global Model
	 */
	private MtgDatabaseModel mtgModel;

	/**
	 * The Model containing the cards
	 */
	private CardsModel model;

	/**
	 * The Handler Service
	 */
	@Inject
	private EHandlerService handlerService;

	/**
	 * Container of the Part
	 */
	private Composite container;

	/**
	 * Parent Composite
	 */
	private Composite parent;

	/**
	 * Tells whether the model is empty or not
	 */
	private boolean empty;

	/**
	 * /** Constructor.
	 * 
	 * @param part
	 *            The current view
	 * @param logger
	 *            The logger
	 * @param parent
	 *            The parent composite
	 * @param modelService
	 *            The model service
	 * @param application
	 *            The application context
	 * @param handlerService
	 *            The handler service
	 * @param commandService
	 *            The command service
	 */
	@Inject
	public DatabaseBrowserPart(MPart part, Logger logger, Composite parent,
			EModelService modelService, MApplication application,
			EHandlerService handlerService, ECommandService commandService) {
		// Initializes model
		ID = part.getElementId();
		this.parent = parent;
		this.handlerService = handlerService;
		mtgModel = ModelProvider.getModel(AppParams.ID, MtgDatabaseModel.class);
		model = ModelProvider.getModel(ID, CardsModel.class);
		model.addListener(this);

		model.addElements(mtgModel.getCardsModel().getElements());

		empty = true;

		buildPart();
	}

	/**
	 * Builds the container of the part
	 */
	private void buildContainer() {
		if (container != null) {
			container.dispose();
		}
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout());
	}

	/**
	 * Builds the part
	 */
	private void buildPart() {
		if (model.getElements().isEmpty()) {
			buildEmptyPart();
			empty = true;
		} else {
			if (empty) {
				buildNotEmptyPart();
				empty = false;
			}
		}
		parent.layout();
	}

	/**
	 * Builds the part for empty Model
	 */
	private void buildEmptyPart() {
		buildContainer();

		StyledText text = new StyledText(container, SWT.WRAP);
		text.setEditable(false);
		text.setCaret(null);
		text.setText("No cards in the database.");
		text.setCursor(new Cursor(container.getDisplay(), SWT.CURSOR_ARROW));
		StyleRange style1 = new StyleRange();
		style1.fontStyle = SWT.ITALIC;
		style1.start = 0;
		style1.length = text.getText().length();
		text.setStyleRange(style1);
	}

	/**
	 * Builds the part for not empty Model
	 */
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
	 * Creates the TableViewer
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	private void createViewer(Composite parent) {
		viewer = new TableViewer(parent, SWT.NONE);

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
		String[] titles = { "Color", "Name", "Set", "Rarity", "Manacost",
				"Ability" };
		int[] bounds = { 5, 10, 5, 5, 10, 65 };

		TableViewerColumn col;

		// Color column
		col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getColor();
			}
		});

		// Name column
		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getName();
			}
		});

		// Set column
		col = createTableViewerColumn(titles[2], bounds[2], 2);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getSet().toString();
			}
		});

		// Rarity column
		col = createTableViewerColumn(titles[3], bounds[3], 3);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getRarity();
			}
		});

		// Manacost column
		col = createTableViewerColumn(titles[4], bounds[4], 4);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getManacost();
			}
		});

		// Ability column
		col = createTableViewerColumn(titles[5], bounds[5], 5);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				CardEx cardEx = (CardEx) element;
				return cardEx.getAbility();
			}
		});

		// Create the cell editors
		CellEditor[] editors = new CellEditor[titles.length];

		editors[0] = new TextCellEditor(table);
		editors[1] = new TextCellEditor(table);
		editors[2] = new TextCellEditor(table);
		editors[3] = new TextCellEditor(table);
		editors[4] = new TextCellEditor(table);
		editors[5] = new TextCellEditor(table);

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
	public TableViewer getViewer() {
		return viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsAdded(List<? extends IModelElement> elements) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				buildPart();

				viewer.refresh();
				packTable();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
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
		model.addElements(mtgModel.getCardsModel().getElements());
	}

	@Override
	public void elementsChecked(List<IModelCheckElement> elements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elementsUnchecked(List<IModelCheckElement> elements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elementsToggled(List<IModelCheckElement> elements) {
		// TODO Auto-generated method stub
		
	}
}