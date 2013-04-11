package com.mmyumu.magictome.ui.statusbar;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.ProgressProvider;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

import com.mmyumu.magictome.events.EventConstants;
import com.mmyumu.magictome.model.IListModelListener;
import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.params.AppParams;
import com.mmyumu.magictome.rmi.api.Api;
import com.mmyumu.magictome.wizard.update.SetsSelectionPart;
import com.mmyumu.magictome.wizard.update.UpdateWizard;

/**
 * Label + ProgressBar
 * 
 * @author mmyumu
 * 
 */
public class UpdateStatusBar implements IProgressMonitor, IListModelListener {
	/**
	 * The ID of the Update Status Bar
	 */
	public final static String ID = "com.mmyumu.magic-tome.updatestatusbar";

	/**
	 * Logger
	 */
	@Inject
	private Logger logger;

	/**
	 * Progress Bar on the right
	 */
	private ProgressBar progressBar;

	/**
	 * Label on the left
	 */
	private Label label;

	/**
	 * Parent of the container of the Update Status Bar
	 */
	private Composite parent;

	/**
	 * Container of the Update Status Bar
	 */
	private Composite container;

	/**
	 * Model of the Update Status Bar
	 */
	private SetsModel modelUpdate;

	/**
	 * Tells whether the monitor is in progress or not
	 */
	private boolean inProgress;

	/**
	 * Host Windows (Context)
	 */
	@Inject
	private MWindow hostWin;

	/**
	 * The broker for events
	 */
	@Inject
	private IEventBroker broker;

	@Inject
	private MToolControl toolControl;

	/**
	 * Initializes the Update Status Bar
	 * 
	 * @param parent
	 *            the parent composite
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		modelUpdate = (SetsModel) ModelProvider.getModel(SetsSelectionPart.ID,
				SetsModel.class);
		modelUpdate.addListener(this);
		parent.setLayout(new GridLayout(2, false));
		this.parent = parent;

		buildContainer();
	}

	/**
	 * Build the container of the Update Status Bar
	 */
	private void buildContainer() {
		this.container = new Composite(parent, SWT.NONE);
		this.container.setLayout(new GridLayout(2, false));
		this.container.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				true));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void worked(final int work) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				progressBar.setSelection(progressBar.getSelection() + work);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void subTask(String name) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setTaskName(String name) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCanceled(boolean value) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCanceled() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void internalWorked(double work) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void done() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beginTask(final String name, final int totalWork) {
		inProgress = true;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				container.dispose();
				buildContainer();

				// Adds label of progres bar
				label = new Label(container, SWT.NONE);
				GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, true,
						false);
				label.setLayoutData(gridData);
				label.setText(name);

				// Add progress bar
				progressBar = new ProgressBar(container, SWT.SMOOTH);
				progressBar.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
						false, false));
				progressBar.setMaximum(totalWork);

				parent.getShell().layout();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void elementsAdded(List<? extends IModelElement> elements) {
	}

	@Override
	public void elementsRemoved(List<? extends IModelElement> elements,
			int index) {
	}

	/**
	 * @return the inProgress
	 */
	public boolean isInProgress() {
		return inProgress;
	}

	/**
	 * Fired when the Update Database is done
	 * 
	 * @param event
	 *            The Job Change Event
	 */
	@Inject
	@Optional
	public void getEvent(
			@UIEventTopic(EventConstants.EVENT_UPDATE_SETS_DONE) IJobChangeEvent event) {
		container.dispose();
		buildContainer();
		inProgress = false;
		if (event.getResult().isOK()) {
			buildUpdateResult();
		} else {
			buildIconText("sample.gif", "Connection error",
					"The server might be offline", false, null);
		}
	}

	@Inject
	@Optional
	public void getEvent(@UIEventTopic(EventConstants.EVENT_TEST_ALL) String str) {
		System.out.println("EVENT RCV=" + str);
	}

	/**
	 * Builds the Update Status Bar after calling Update Database Handler
	 */
	private void buildUpdateResult() {
		if (modelUpdate.getElements().isEmpty()) {
			buildIconText("sample.gif", "No set found", null, false, null);
		} else {
			buildIconText("sample.gif", "New sets found!",
					"Click here to download the new sets", true,
					new MouseListener() {
						@Override
						public void mouseUp(MouseEvent event) {
							UpdateWizard updateWizard = (UpdateWizard) ContextInjectionFactory
									.make(UpdateWizard.class,
											hostWin.getContext());
							WizardDialog dialog = new WizardDialog(parent
									.getShell(), updateWizard);
							int result = dialog.open();
							if (result == WizardDialog.OK) {
								downloadCards();
							}
						}

						@Override
						public void mouseDown(MouseEvent e) {
						}

						@Override
						public void mouseDoubleClick(MouseEvent e) {
						}
					});
		}
	}

	/**
	 * Download the cards from the checked sets
	 */
	private void downloadCards() {
		Job job = new Job("Update database") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Update cards definitions", modelUpdate
						.getElements().size() * 10);
				MtgDatabaseModel mtgModel = ModelProvider.getModel(
						AppParams.ID, MtgDatabaseModel.class);

				int work = 0;
				List<IModelCheckElement> elements = new ArrayList<>(
						modelUpdate.getElements());
				for (IModelCheckElement elt : elements) {
					if (elt.isChecked()) {
						SetEx set = (SetEx) elt;
						// RMI Call
						Registry registry;
						try {
							registry = LocateRegistry.getRegistry(
									AppParams.HOST, AppParams.PORT);
							Api remoteApi = (Api) registry.lookup(Api.class
									.getSimpleName());
							List<IModelElement> cards = remoteApi.getCards(set);
							mtgModel.getCardsModel().addElements(cards);

							List<IModelCheckElement> toBeAdded = new ArrayList<>();
							toBeAdded.add(elt);
							work += 10;
							monitor.worked(work);

							mtgModel.getSetsModel().addElements(toBeAdded);
							modelUpdate.removeElements(toBeAdded);
						} catch (RemoteException e) {
							logger.error(e, "Exception RMI");
							return Status.CANCEL_STATUS;
						} catch (NotBoundException e) {
							logger.error(e, "Not bound");
							return Status.CANCEL_STATUS;
						}
					}
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};

		job.addJobChangeListener(new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				broker.send(EventConstants.EVENT_UPDATE_CARDS_DONE, event);
				broker.send(EventConstants.EVENT_UPDATE_SETS_DONE, event);
			}
		});

		Object widget = toolControl.getObject();
		final IProgressMonitor p = (IProgressMonitor) widget;
		ProgressProvider provider = new ProgressProvider() {
			@Override
			public IProgressMonitor createMonitor(Job job) {
				return p;
			}
		};

		// Setting the progress monitor
		IJobManager manager = Job.getJobManager();
		manager.setProgressProvider(provider);
		job.schedule();
	}

	/**
	 * Builds icon + styledText with optional link and listener
	 * 
	 * @param icon
	 *            the icon
	 * @param text
	 *            the text
	 * @param isLink
	 *            determines if it's a link style
	 * @param mouseListener
	 *            the MouseListener added to the icon and text if it's not null
	 */
	private void buildIconText(String icon, String text, String toolTip,
			boolean isLink, MouseListener mouseListener) {
		try {
			boolean underline = false;
			// Add update image
			Image img = ImageDescriptor.createFromURL(
					new URL("platform:/plugin/com.mmyumu.magic-tome/icons/"
							+ icon)).createImage();
			Label imgLabel = new Label(container, SWT.NONE);
			if (isLink) {
				imgLabel.setCursor(new Cursor(parent.getDisplay(),
						SWT.CURSOR_HAND));
				underline = true;
			}
			imgLabel.setImage(img);

			if (mouseListener != null) {
				imgLabel.addMouseListener(mouseListener);
			}

			// Add update text
			StyledText styledText = new StyledText(container, SWT.NONE);
			styledText.setText(text);
			styledText.setEditable(false);
			styledText.setCaret(null);
			if (toolTip != null) {
				styledText.setToolTipText(toolTip);
			}
			StyleRange style1 = new StyleRange();
			style1.underline = underline;
			style1.start = 0;
			style1.length = text.length();
			if (isLink) {
				style1.underlineStyle = SWT.UNDERLINE_LINK;
			} else {
				styledText.setCursor(new Cursor(parent.getDisplay(),
						SWT.CURSOR_ARROW));
			}
			style1.background = parent.getBackground();
			styledText.setStyleRange(style1);

			if (mouseListener != null) {
				styledText.addMouseListener(mouseListener);
			}

			parent.getShell().layout();
		} catch (MalformedURLException e) {
			logger.error(e, "Error in icon URL");
		}
	}
}
