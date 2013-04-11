package com.mmyumu.magictome.ui.statusbar;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Composite;

/**
 * Displays results according to the updating database result
 * 
 * @author mmyumu
 * 
 */
public class UpdateResultStatus {
	public static String ID;

	@PostConstruct
	public void createControls(Composite parent) {
		System.out.println("update result status built");
	}

	@Execute
	public void execute() {
		System.out.println("execute");
	}

	@CanExecute
	public void canExecute() {
		System.out.println("can execute");
	}
}
