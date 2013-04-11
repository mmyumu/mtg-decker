package com.mmyumu.magictome.model;

import java.util.ArrayList;
import java.util.List;

public class Model<T extends IModelElement> {
	/**
	 * The elements list of the Model
	 */
	protected List<T> elements;

	/**
	 * The listeners list of the Model
	 */
	protected List<IModelListener> listeners;

	/**
	 * Constructor. Initializes lists
	 */
	public Model() {
		elements = new ArrayList<T>();
		listeners = new ArrayList<IModelListener>();
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
			for (IModelListener listener : listeners) {
				listener.elementsAdded();
			}
		}
	}

	/**
	 * 
	 * @param elements
	 */
	public void removeElements(List<? extends IModelElement> elements) {
		if (elements == null || elements.isEmpty()) {
			return;
		}
		List<IModelElement> listToRemove = new ArrayList<IModelElement>(
				elements);
		// int index = this.elements.indexOf(listToRemove.get(0));
		if (!this.elements.containsAll(listToRemove)) {
			return;
		}
		this.elements.removeAll(listToRemove);
		// for (IModelListener listener : listeners) {
		// listener.elementsRemoved(listToRemove, index);
		// }
	}

	/**
	 * Adds a listener to the Model
	 * 
	 * @param listener
	 *            the listener to add to the Model
	 */
	public void addListener(IModelListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
}
