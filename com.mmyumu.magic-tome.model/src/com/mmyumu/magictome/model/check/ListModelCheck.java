package com.mmyumu.magictome.model.check;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mmyumu.magictome.model.ListModel;

/**
 * Model for a list of checkable elements
 * 
 * @author mmyumu
 * 
 */
public class ListModelCheck extends ListModel<IModelCheckElement> implements
		Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Listeners for checkable model
	 */
	protected transient List<IListModelCheckListener> listeners;

	/**
	 * Constructor.
	 */
	public ListModelCheck() {
		listeners = new ArrayList<IListModelCheckListener>();
	}

	/**
	 * Check elements in the list
	 * 
	 * @param elements
	 *            the elements to check in the Model
	 */
	public void checkElements(List<IModelCheckElement> elements) {
		List<IModelCheckElement> toBeChecked = new ArrayList<IModelCheckElement>();
		for (IModelCheckElement elt : elements) {
			if (!toBeChecked.contains(elt)) {
				elt.setChecked(true);
				toBeChecked.add(elt);
			}
		}
		if (!toBeChecked.isEmpty()) {
			for (IListModelCheckListener listener : listeners) {
				listener.elementsChecked(toBeChecked);
			}
		}
	}

	/**
	 * Uncheck elements in the list
	 * 
	 * @param elements
	 *            the elements to uncheck in the Model
	 */
	public void uncheckElements(List<IModelCheckElement> elements) {
		List<IModelCheckElement> toBeUnchecked = new ArrayList<IModelCheckElement>();
		for (IModelCheckElement elt : elements) {
			if (!toBeUnchecked.contains(elt)) {
				elt.setChecked(false);
				toBeUnchecked.add(elt);
			}
		}
		if (!toBeUnchecked.isEmpty()) {
			for (IListModelCheckListener listener : listeners) {
				listener.elementsUnchecked(toBeUnchecked);
			}
		}
	}

	/**
	 * Toggle the checkstate of the elements in the list
	 * 
	 * @param elements
	 *            the elements to toggle in the Model
	 */
	public void toggleElements(List<IModelCheckElement> elements) {
		List<IModelCheckElement> toBeToggled = new ArrayList<IModelCheckElement>();
		for (IModelCheckElement elt : elements) {
			if (!toBeToggled.contains(elt)) {
				elt.setChecked(!elt.isChecked());
				toBeToggled.add(elt);
			}
		}
		if (!toBeToggled.isEmpty()) {
			for (IListModelCheckListener listener : listeners) {
				listener.elementsToggled(toBeToggled);
			}
		}
	}

	/**
	 * Adds a listener to the checkable Model
	 * 
	 * @param listener
	 *            the listener to add to the checkable Model
	 */
	public void addListener(IListModelCheckListener listener) {
		super.addListener(listener);
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	/**
	 * Gets the difference between the list of current Model and the list given
	 * as parameter.
	 * 
	 * @param elements
	 *            the list of elements to compare
	 * @return each element in the list given as parameter which is not in the
	 *         current model
	 */
	public List<IModelCheckElement> getDiff(List<IModelCheckElement> elements) {
		List<IModelCheckElement> diff = new ArrayList<IModelCheckElement>();
		for (IModelCheckElement elt : elements) {
			if (!containsById(elt)) {
				diff.add(elt);
			}
		}
		return diff;
	}

	/**
	 * Tells whether the model contains an element with the same ID
	 * 
	 * @param elt
	 *            element to find
	 * @return true if the element is contained in the model, false otherwise
	 */
	public boolean containsById(IModelCheckElement elt) {
		for (IModelCheckElement elt2 : this.elements) {
			if (elt2.getId().compareTo(elt.getId()) == 0) {
				return true;
			}
		}
		return false;
	}
}
