package com.mmyumu.magictome.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import com.mmyumu.magictome.model.check.ListModelCheck;
import com.mmyumu.magictome.ui.IListModelPart;

/**
 * Handler for the "Select/Unselect all". Uncheck all the items when they're all
 * checked
 * 
 * @author mmyumu
 * 
 */
public class UnselectAllHandler extends AllSelectionHandler {

	@SuppressWarnings("unchecked")
	@Execute
	public void execute(MPart part) {
		IListModelPart<ListModelCheck> modelPart = (IListModelPart<ListModelCheck>) part
				.getObject();
		if (model == null) {
			model = modelPart.getModel();
		}

		model.uncheckElements(model.getElements());
	}
}