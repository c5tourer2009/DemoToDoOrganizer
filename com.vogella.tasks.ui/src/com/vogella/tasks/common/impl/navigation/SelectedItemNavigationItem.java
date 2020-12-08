package com.vogella.tasks.common.impl.navigation;

import com.vogella.tasks.common.interfaces.navigation.ISelectedItemNavigationItem;

public class SelectedItemNavigationItem<T> implements ISelectedItemNavigationItem<T> {

	private final T selectedItem;
	
	public SelectedItemNavigationItem(T selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	@Override
	public T getSelectedItem() {
		return selectedItem;
	}
}
