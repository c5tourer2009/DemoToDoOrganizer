package com.vogella.tasks.common.impl.navigation;

import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.navigation.IOrganizerNavigationItem;

public class OrganizerNavigationItem extends SelectedItemNavigationItem<Object> implements IOrganizerNavigationItem {

	private final IToDoList toDoList;
	
	public OrganizerNavigationItem(Object selectedItem, IToDoList toDoList) {
		super(selectedItem);
		this.toDoList = toDoList;
	}

	@Override
	public IToDoList getToDoList() {
		return toDoList;
	}
}
