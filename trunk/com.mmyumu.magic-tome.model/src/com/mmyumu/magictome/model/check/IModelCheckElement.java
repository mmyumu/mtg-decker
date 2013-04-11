package com.mmyumu.magictome.model.check;

import com.mmyumu.magictome.model.IModelElement;

/**
 * Interface for a checkable Model Element
 * 
 * @author mmyumu
 * 
 */
public interface IModelCheckElement extends IModelElement {
	/**
	 * Tells whether the element is checked or not
	 * 
	 * @return true if checked, false otherwise
	 */
	public boolean isChecked();

	/**
	 * Sets the check state of the element
	 * 
	 * @param checked
	 */
	public void setChecked(boolean checked);
}
