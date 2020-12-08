package com.vogella.tasks.common.interfaces.navigation;

import com.vogella.tasks.common.interfaces.IToDoList;

public interface IOrganizerNavigationItem extends ISelectedItemNavigationItem<Object> {
	
	IToDoList getToDoList();
}
