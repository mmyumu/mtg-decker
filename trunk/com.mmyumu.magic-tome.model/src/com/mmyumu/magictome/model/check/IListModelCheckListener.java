package com.mmyumu.magictome.model.check;

import java.util.List;

import com.mmyumu.magictome.model.IListModelListener;

/**
 * Interface for a listener of checkable model
 * 
 * @author mmyumu
 * 
 */
public interface IListModelCheckListener extends IListModelListener {
	/**
	 * Fired when elements are checked
	 * 
	 * @param elements
	 *            the checked elements
	 */
	public void elementsChecked(List<IModelCheckElement> elements);

	/**
	 * Fired when elements are unchecked
	 * 
	 * @param elements
	 *            the unckeched elements
	 */
	public void elementsUnchecked(List<IModelCheckElement> elements);

	/**
	 * Fired when elements are toggled
	 * 
	 * @param elements
	 *            the toggled elements
	 */
	public void elementsToggled(List<IModelCheckElement> elements);
}