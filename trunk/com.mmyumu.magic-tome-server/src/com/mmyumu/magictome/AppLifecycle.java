package com.mmyumu.magictome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;

import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.params.AppParams;

public class AppLifecycle {
	@Inject
	private static Logger logger;

	private static MtgDatabaseModel mtgModel;

	/**
	 * Loads the serialized database.
	 * 
	 * @param eclipseContext
	 */
	@PostContextCreate
	public static void load(IEclipseContext eclipseContext) {
		mtgModel = ModelProvider.getModel(AppParams.ID, MtgDatabaseModel.class);
		// Object deserialization
		try {
			FileInputStream fis = new FileInputStream(AppParams.DB_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MtgDatabaseModel model = (MtgDatabaseModel) ois.readObject();
			mtgModel.getSetsModel().addElements(
					model.getSetsModel().getElements());
			mtgModel.getCardsModel().addElements(
					model.getCardsModel().getElements());
			ois.close();
		} catch (FileNotFoundException e) {
			logger.error(e, "File not found");
		} catch (IOException e) {
			logger.error(e, "Error during deserialization");
		} catch (ClassNotFoundException e) {
			logger.error(e, "Class not found");
		}

	}

	/**
	 * Serializes the database
	 */
	@PreSave
	public static void save() {
		// Object serialization
		try {
			FileOutputStream fos = new FileOutputStream(AppParams.DB_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mtgModel);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			logger.error(e, "File not found during serialization");
		} catch (IOException e) {
			logger.error(e, "Error during serialization");
		}
	}
}
