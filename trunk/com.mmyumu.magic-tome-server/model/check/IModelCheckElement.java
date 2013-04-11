package com.mmyumu.magictome.model.check;

import com.mmyumu.magictome.model.IModelElement;

public interface IModelCheckElement extends IModelElement {
	public boolean isChecked();

	public void setChecked(boolean checked);
}
