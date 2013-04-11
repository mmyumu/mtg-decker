package com.mmyumu.magictome.model;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;

public class ModelProvider {

	@Inject
	private static Logger logger;
	private static Map<String, Model<? extends IModelElement>> models = new HashMap<String, Model<? extends IModelElement>>();

	public static <T extends Model<? extends IModelElement>> T getModel(
			String id, Class<T> modelClass) {
		@SuppressWarnings("unchecked")
		T model = (T) models.get(id);

		if (model == null) {
			try {
				model = modelClass.newInstance();
			} catch (InstantiationException e) {
				logger.error(e, "Error when creating new instance of class "
						+ modelClass.getName());
			} catch (IllegalAccessException e) {
				logger.error(e, "Error when creating new instance of class "
						+ modelClass.getName());
			}
			models.put(id, model);
		}
		return model;
	}
}
