package com.mmyumu.magictome.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import com.mmyumu.magictome.model.check.ListModelCheck;
import com.mmyumu.magictome.ui.IListModelPart;

public abstract class AllSelectionHandler {
	/**
	 * The Model
	 */
	protected ListModelCheck model;

	@Execute
	public abstract void execute(MPart part);

	@SuppressWarnings("unchecked")
	@CanExecute
	public boolean canExecute(MPart part) {
		IListModelPart<ListModelCheck> modelPart = (IListModelPart<ListModelCheck>) part
				.getObject();
		if (model == null) {
			model = modelPart.getModel();
		}
		if (model.getElements().isEmpty()) {
			return false;
		}
		return true;
	}
}
