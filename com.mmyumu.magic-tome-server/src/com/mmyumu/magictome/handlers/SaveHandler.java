/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.mmyumu.magictome.handlers;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

//import org.eclipse.e4.ui.workbench.Persist;

public class SaveHandler implements IProgressMonitor {
	@CanExecute
	public boolean canExecute(
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {
		if (dirtyable == null) {
			return false;
		}
		return dirtyable.isDirty();
	}

	@Execute
	public void execute(
			IEclipseContext context,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) final MContribution contribution)
			throws InvocationTargetException, InterruptedException {
		final IEclipseContext pmContext = context.createChild();

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		dialog.open();
		dialog.run(true, true, new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				pmContext.set(IProgressMonitor.class.getName(), monitor);
				if (contribution != null) {
					Object clientObject = contribution.getObject();
					//					ContextInjectionFactory.invoke(clientObject, Persist.class, //$NON-NLS-1$
					// pmContext, null);
				}
			}
		});

		pmContext.dispose();
	}

	@Override
	public void beginTask(String name, int totalWork) {
		// TODO Auto-generated method stub

	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalWorked(double work) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanceled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanceled(boolean value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTaskName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subTask(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void worked(int work) {
		// TODO Auto-generated method stub

	}
}
