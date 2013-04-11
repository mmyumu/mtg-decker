package com.mmyumu.magictome.model.sets;

import java.io.Serializable;

import com.mmyumu.magictome.model.check.IModelCheckElement;
import com.mmyumu.magictome.model.xml.Set;

public class SetEx extends Set implements IModelCheckElement, Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tells whether the set is used or not in the database
	 */
	private boolean used = true;

	@Override
	public String toString() {
		return getName();
	}

	/**
	 * @return the used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * @param used
	 *            the used to set
	 */
	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public boolean isChecked() {
		return used;
	}

	@Override
	public void setChecked(boolean checked) {
		used = checked;
	}
}
