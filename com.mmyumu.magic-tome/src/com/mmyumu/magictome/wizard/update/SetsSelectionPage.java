package com.mmyumu.magictome.wizard.update;

import javax.inject.Inject;

import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class SetsSelectionPage extends WizardPage {
	/**
	 * Container of the Sets Selecter Page
	 */
	private Composite container;

	@Inject
	private EPartService partService;

	@Inject
	private IPresentationEngine renderer;

	@Inject
	private MWindow hostWin;

	@Inject
	private EModelService modelService;

	@Inject
	private MApplication application;

	@Inject
	private ECommandService commandService;

	protected SetsSelectionPage(String pageName) {
		super(pageName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		setTitle("Sets selection");
		setDescription("Select the sets you want to download. The download of the selected sets will\r\nstart when you click on the Finish button");
		container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));

		// Initializes layout
		if (container.getLayout() == null)
			container.setLayout(new FillLayout());

		// Creates composite
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout());

		// Create a second 'simple' e4-based part MPart simple =
		MPart simple = MBasicFactory.INSTANCE.createPart();
		simple.setElementId("com.mmyumu.magictome.wizard.update.setsselectionpart");
		ContextInjectionFactory.inject(simple, hostWin.getContext());
		simple.setLabel("Simple Part");
		simple.setContributionURI("bundleclass://com.mmyumu.magic-tome/com.mmyumu.magictome.wizard.update.SetsSelectionPart");
		simple.setCloseable(false);

		// Wrap the parts in a stack MPartStack stack =
		MPartStack stack = MBasicFactory.INSTANCE.createPartStack();
		stack.setElementId("com.mmyumu.magictome.wizard.update.setsselectionpartstack");
		stack.getChildren().add(simple);

		renderModel(composite, hostWin, stack);

		setPageComplete(true);

		// Required to avoid system error
		setControl(container);
	}

	private void renderModel(Composite parent, final MWindow hostWin,
			final MUIElement hostModel) {
		// This is subtle; unless the element is hooked into the model it won't
		// fire events
		hostWin.getSharedElements().add(hostModel);

		// Render it
		renderer.createGui(hostModel, parent, hostWin.getContext());

		// Clean up the shared elements list once we're done
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				hostWin.getSharedElements().remove(hostModel);
			}
		});
	}
}
