package com.mmyumu.magictome.ui.monitor;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;

public class MyProgressMonitor implements IProgressMonitor {
	private ProgressBar progressBar;

	public MyProgressMonitor(Composite parent) {
		progressBar = new ProgressBar(parent, SWT.SMOOTH);
		progressBar.setBounds(100, 10, 200, 20);
	}

	@PostConstruct
	public void createControls(Composite parent) {

	}

	@Override
	public void worked(final int work) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				progressBar.setSelection(progressBar.getSelection() + work);
			}
		});
	}

	@Override
	public void subTask(String name) {

	}

	@Override
	public void setTaskName(String name) {

	}

	@Override
	public void setCanceled(boolean value) {

	}

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void internalWorked(double work) {
	}

	@Override
	public void done() {

	}

	@Override
	public void beginTask(String name, int totalWork) {
	}
}