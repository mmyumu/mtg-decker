package com.mmyumu.magictome.wizard.update;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jface.wizard.Wizard;

/**
 * Wizard for update database
 * 
 * @author mmyumu
 * 
 */
public class UpdateWizard extends Wizard {
	@Inject
	private MWindow hostWin;

	@Override
	public void addPages() {
		SetsSelectionPage setsSelecterPage = new SetsSelectionPage(
				"Sets Selection");
		ContextInjectionFactory.inject(setsSelecterPage, hostWin.getContext());
		setWindowTitle("Database update");
		setNeedsProgressMonitor(true);
		addPage(setsSelecterPage);
	}

	@Override
	public boolean performFinish() {
		return true;
	}
}
