package com.mmyumu.magictome.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic Model Class for list of elements
 * 
 * @author mmyumu
 * 
 * @param <T>
 *            The Model Element of the list
 */
public class ListModel<T extends IModelElement> extends Model implements
		Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The elements list of the Model
	 */
	protected List<T> elements;

	/**
	 * The listeners list of the Model
	 */
	protected transient List<IListModelListener> listeners;

	/**
	 * Constructor. Initializes lists
	 */
	public ListModel() {
		elements = new ArrayList<T>();
		listeners = new ArrayList<IListModelListener>();
	}

	/**
	 * Gets the elements list
	 * 
	 * @return the elements list
	 */
	public List<T> getElements() {
		return elements;
	}

	/**
	 * Adds elements to the elements list
	 * 
	 * @param elements
	 *            the elements to add to the Model
	 */
	public void addElements(List<T> elements) {
		List<T> toBeAdded = new ArrayList<T>();
		for (T elt : elements) {
			if (!toBeAdded.contains(elt)) {
				toBeAdded.add(elt);
			}
		}
		if (!toBeAdded.isEmpty()) {
			this.elements.addAll(toBeAdded);
			for (IListModelListener listener : listeners) {
				listener.elementsAdded(toBeAdded);
			}
		}
	}

	/**
	 * 
	 * @param elements
	 */
	public void removeElements(List<T> elements) {
		if (elements == null || elements.isEmpty()) {
			return;
		}
		List<T> listToRemove = new ArrayList<>(elements);
		int index = this.elements.indexOf(listToRemove.get(0));
		if (!this.elements.containsAll(listToRemove)) {
			return;
		}
		this.elements.removeAll(listToRemove);
		for (IListModelListener listener : listeners) {
			listener.elementsRemoved(listToRemove, index);
		}
	}

	/**
	 * Adds a listener to the Model
	 * 
	 * @param listener
	 *            the listener to add to the Model
	 */
	public void addListener(IListModelListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
}
