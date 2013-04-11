package com.mmyumu.magictome.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import com.mmyumu.magictome.model.check.ListModelCheck;
import com.mmyumu.magictome.ui.IListModelPart;

public class SelectAllHandler extends AllSelectionHandler {

	@SuppressWarnings("unchecked")
	@Execute
	public void execute(MPart part) {
		IListModelPart<ListModelCheck> modelPart = (IListModelPart<ListModelCheck>) part
				.getObject();
		if (model == null) {
			model = modelPart.getModel();
		}

		model.checkElements(model.getElements());
	}
}