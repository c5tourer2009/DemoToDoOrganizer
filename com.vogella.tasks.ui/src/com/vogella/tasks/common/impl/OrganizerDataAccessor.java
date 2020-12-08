package com.vogella.tasks.common.impl;

import com.vogella.tasks.common.factories.DemoToDoListFactory;
import com.vogella.tasks.common.interfaces.IOrganizerDataAccessor;
import com.vogella.tasks.common.interfaces.IToDoList;

public class OrganizerDataAccessor implements IOrganizerDataAccessor {

	private final IToDoList toDoList;

	public OrganizerDataAccessor() {
		toDoList = DemoToDoListFactory.createDemoToDoList("To-Do List");
	}
	
	@Override
	public IToDoList getToDoList() {
		return toDoList;
	}
}
