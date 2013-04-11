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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.mmyumu.magictome.AppLifecycle;
import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.card.CardEx;
import com.mmyumu.magictome.model.card.CardsModel;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.sets.SetsModel;
import com.mmyumu.magictome.model.xml.Card;
import com.mmyumu.magictome.model.xml.MtgCarddatabase;
import com.mmyumu.magictome.model.xml.ObjectFactoryEx;
import com.mmyumu.magictome.model.xml.Set;
import com.mmyumu.magictome.params.AppParams;

public class OpenHandler {
	@Inject
	private Logger logger;

	@Inject
	private EModelService modelService;

	@Inject
	private MApplication application;

	@Execute
	public void execute(IEclipseContext context,
			@Named(IServiceConstants.ACTIVE_SHELL) final Shell shell)
			throws InvocationTargetException, InterruptedException {
		FileDialog dialog = new FileDialog(shell);
		dialog.setFilterExtensions(new String[] { "*.xml" });
		dialog.setFilterNames(new String[] { "MTG Database XML File" });
		dialog.setText("Open MTG Database");
		final String filePath = dialog.open();

		if (filePath != null) {
			ProgressMonitorDialog monitorDialog = new ProgressMonitorDialog(
					shell);
			monitorDialog.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) {
					monitor.beginTask("Importing card database", 100);
					try {
						JAXBContext jc = JAXBContext
								.newInstance(MtgCarddatabase.class);
						Unmarshaller unmarshaller = jc.createUnmarshaller();

						unmarshaller.setProperty(
								"com.sun.xml.internal.bind.ObjectFactory",
								new ObjectFactoryEx());
						monitor.worked(30);
						final MtgCarddatabase mtgCarddatabase = (MtgCarddatabase) unmarshaller
								.unmarshal(new File(filePath));
						monitor.worked(80);
						shell.getDisplay().syncExec(new Runnable() {
							public void run() {
								// Add sets to Model
								List<IModelCheckElement> sets = new ArrayList<>();
								for (Set set : mtgCarddatabase.getSets()
										.getSet()) {
									SetEx setEx = (SetEx) set;
									sets.add(setEx);
								}
								MtgDatabaseModel mtgModel = ModelProvider
										.getModel(AppParams.ID,
												MtgDatabaseModel.class);
								SetsModel setsModel = mtgModel.getSetsModel();
								setsModel.addElements(sets);

								// Add cards to Model
								List<IModelElement> cards = new ArrayList<>();
								for (Card card : mtgCarddatabase.getCards()
										.getCard()) {
									CardEx cardEx = (CardEx) card;
									cards.add(cardEx);
								}
								CardsModel cardsModel = mtgModel
										.getCardsModel();
								cardsModel.addElements(cards);

								AppLifecycle.save();
							}
						});

						// Add cards to the set
						// for (Card card :
						// mtgCarddatabase.getCards().getCard()) {
						// CardEx cardEx = (CardEx) card;
						// ((SetExFull) cardEx.getSet()).addCard(cardEx);
						// }
						monitor.worked(100);
					} catch (JAXBException e) {
						logger.error(e, "Error while parsing XML file");
					}
					monitor.done();
				}
			});
		}

	}
}
