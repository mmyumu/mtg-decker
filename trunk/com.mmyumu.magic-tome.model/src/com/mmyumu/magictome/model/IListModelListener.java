package com.mmyumu.magictome.model;

import java.util.List;

public interface IListModelListener extends IModelListener {

	public void elementsAdded(List<? extends IModelElement> elements);

	public void elementsRemoved(List<? extends IModelElement> elements,
			int index);
}
