package com.vogella.tasks.common.interfaces.navigation;

public interface ISelectedItemNavigationItem<T> extends INavigationItem {
	
	T getSelectedItem();
}
