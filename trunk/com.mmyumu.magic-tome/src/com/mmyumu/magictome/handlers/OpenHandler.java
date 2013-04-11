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

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.model.xml.MtgCarddatabase;
import com.mmyumu.magictome.model.xml.ObjectFactoryEx;
import com.mmyumu.magictome.model.xml.Set;
import com.mmyumu.magictome.ui.sets.SetsPart;

public class OpenHandler {
	@Inject
	private Logger logger;

	@Execute
	public void execute(IEclipseContext context,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell)
			throws InvocationTargetException, InterruptedException {
		FileDialog dialog = new FileDialog(shell);
		String filePath = dialog.open();

		if (filePath != null) {
			try {
				JAXBContext jc = JAXBContext.newInstance(MtgCarddatabase.class);
				Unmarshaller unmarshaller = jc.createUnmarshaller();

				unmarshaller.setProperty(
						"com.sun.xml.internal.bind.ObjectFactory",
						new ObjectFactoryEx());
				MtgCarddatabase mtgCarddatabase = (MtgCarddatabase) unmarshaller
						.unmarshal(new File(filePath));
				List<IModelCheckElement> elements = new ArrayList<IModelCheckElement>();
				for (Set set : mtgCarddatabase.getSets().getSet()) {
					SetEx setEx = (SetEx) set;
					elements.add(setEx);
				}

				SetsModel model = (SetsModel) ModelProvider.getModel(
						SetsPart.ID, SetsModel.class);
				model.addElements(elements);
				model.checkElements(elements);
				// model.checkElements(elements);
			} catch (JAXBException e) {
				logger.error(e, "Error while parsing XML file");
			}
		}

	}
}
