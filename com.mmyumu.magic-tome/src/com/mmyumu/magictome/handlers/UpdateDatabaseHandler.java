package com.mmyumu.magictome.handlers;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.ProgressProvider;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.mmyumu.magictome.events.EventConstants;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.params.AppParams;
import com.mmyumu.magictome.rmi.api.Api;
import com.mmyumu.magictome.ui.statusbar.UpdateStatusBar;
import com.mmyumu.magictome.wizard.update.SetsSelectionPart;

public class UpdateDatabaseHandler {
	/**
	 * The logger
	 */
	@Inject
	private Logger logger;

	/**
	 * The Application Model
	 */
	@Inject
	private MApplication application;

	/**
	 * The Model Service
	 */
	@Inject
	private EModelService modelService;

	/**
	 * The broker for events
	 */
	@Inject
	private IEventBroker broker;

	/**
	 * Called when the Update Database command is clicked
	 */
	@Execute
	public void execute() {
		broker.send(EventConstants.EVENT_TEST_1, "solo");
		broker.send(EventConstants.EVENT_TEST_2, "solo");
		// Get the ToolControl from the Application Model
		final MToolControl element = (MToolControl) modelService.find(
				UpdateStatusBar.ID, application);

		Job job = new Job("Update database") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				UpdateStatusBar updateStatusBar = (UpdateStatusBar) monitor;

				// Cancel this job if another update job is already running
				if (updateStatusBar.isInProgress()) {
					return Status.CANCEL_STATUS;
				}
				// Set total number of work units
				monitor.beginTask("Updating sets definitions", 100);

				try {
					// RMI Call
					final Registry registry = LocateRegistry.getRegistry(
							AppParams.HOST, AppParams.PORT);
					Api remoteApi = (Api) registry.lookup(Api.class
							.getSimpleName());
					monitor.worked(10);
					List<IModelCheckElement> elements = remoteApi.getSets();
					monitor.worked(60);

					SetsModel model = ModelProvider.getModel(AppParams.ID,
							MtgDatabaseModel.class).getSetsModel();
					SetsModel modelUpdate = ModelProvider.getModel(
							SetsSelectionPart.ID, SetsModel.class);
					modelUpdate.removeElements(modelUpdate.getElements());

					monitor.worked(70);
					modelUpdate.addElements(model.getDiff(elements));
					monitor.worked(100);
					return Status.OK_STATUS;
				} catch (RemoteException e) {
					logger.error(e, "Exception RMI");
					return Status.CANCEL_STATUS;
				} catch (NotBoundException e) {
					logger.error(e, "Not bound");
					return Status.CANCEL_STATUS;
				} finally {
					monitor.done();
				}
			}
		};

		job.addJobChangeListener(new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				broker.send(EventConstants.EVENT_UPDATE_SETS_DONE, event);
			}
		});

		Object widget = element.getObject();
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

	@CanExecute
	public boolean canExecute() {
		return true;
	}
}
