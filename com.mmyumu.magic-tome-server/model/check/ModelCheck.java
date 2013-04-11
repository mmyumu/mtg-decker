package com.mmyumu.magictome.model.check;

import java.util.ArrayList;
import java.util.List;

import com.mmyumu.magictome.model.Model;

public class ModelCheck extends Model<IModelCheckElement> {

	protected List<IModelCheckListener> listeners;

	public ModelCheck() {
		listeners = new ArrayList<IModelCheckListener>();
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
			for (IModelCheckListener listener : listeners) {
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
			for (IModelCheckListener listener : listeners) {
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
			for (IModelCheckListener listener : listeners) {
				listener.elementsToggled(toBeToggled);
			}
		}
	}

	public void addListener(IModelCheckListener listener) {
		super.addListener(listener);
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
}
