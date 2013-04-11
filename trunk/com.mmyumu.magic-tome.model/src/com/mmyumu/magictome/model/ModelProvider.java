package com.mmyumu.magictome.model;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.core.services.log.Logger;

/**
 * Provides Model unique for the given String ID
 * 
 * @author mmyumu
 * 
 */
public class ModelProvider {

	/**
	 * The logger
	 */
	@Inject
	private static Logger logger;

	/**
	 * The models
	 */
	// private static Map<String, ListModel<? extends IListModelElement>> models
	// = new HashMap<String, ListModel<? extends IListModelElement>>();
	private static Map<String, Model> models = new HashMap<String, Model>();

	/**
	 * Gets the unique Model for the given string ID. Creates the model if it
	 * doesn't exist
	 * 
	 * @param id
	 *            the id of the model
	 * @param modelClass
	 *            the class of the model
	 * @return the model
	 */
	public static <T extends Model> T getModel(String id, Class<T> modelClass) {
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
