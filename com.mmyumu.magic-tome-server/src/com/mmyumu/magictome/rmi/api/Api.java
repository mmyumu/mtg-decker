package com.mmyumu.magictome.rmi.api;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.mmyumu.magictome.model.IModelElement;
import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.xml.Set;

public interface Api extends Remote {
	public List<IModelCheckElement> getSets() throws RemoteException;

	public List<IModelElement> getCards(Set set) throws RemoteException;
}
