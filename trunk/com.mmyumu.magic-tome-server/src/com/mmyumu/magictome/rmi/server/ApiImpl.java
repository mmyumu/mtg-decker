package com.mmyumu.magictome.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.ModelProvider;
import com.mmyumu.magictome.model.card.CardEx;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.mtgcarddatabase.MtgDatabaseModel;
import com.mmyumu.magictome.model.sets.SetEx;
import com.mmyumu.magictome.model.xml.Set;
import com.mmyumu.magictome.params.AppParams;
import com.mmyumu.magictome.rmi.api.Api;

public class ApiImpl extends UnicastRemoteObject implements Api {
	private static final long serialVersionUID = 1L;

	public ApiImpl() throws RemoteException {
		super();
	}

	@Override
	public List<IModelCheckElement> getSets() throws RemoteException {
		return ModelProvider.getModel(AppParams.ID, MtgDatabaseModel.class)
				.getSetsModel().getElements();
	}

	@Override
	public List<IModelElement> getCards(Set set) throws RemoteException {
		MtgDatabaseModel model = ModelProvider.getModel(AppParams.ID,
				MtgDatabaseModel.class);
		List<IModelElement> elements = new ArrayList<>();
		for (IModelElement elt : model.getCardsModel().getElements()) {
			CardEx cardEx = (CardEx) elt;
			SetEx setEx = (SetEx) cardEx.getSet();
			if (setEx.getName().compareTo(set.getName()) == 0) {
				elements.add(cardEx);
			}
		}
		return elements;
	}
}