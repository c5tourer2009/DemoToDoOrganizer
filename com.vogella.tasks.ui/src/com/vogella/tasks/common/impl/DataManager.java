package com.vogella.tasks.common.impl;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import com.vogella.tasks.common.factories.DemoToDoListFactory;
import com.vogella.tasks.common.interfaces.IDataManager;
import com.vogella.tasks.common.interfaces.IToDoList;

public class DataManager implements IDataManager {

	private final WritableList<IToDoList> toDoLists;

	public DataManager() {
		toDoLists = new WritableList<IToDoList>();
		
		toDoLists.add(DemoToDoListFactory.createDemoToDoList());
		toDoLists.add(DemoToDoListFactory.createDemoToDoList());
	}
	
	@Override
	public IObservableList<IToDoList> getToDoLists() {
		return toDoLists;
	}
}
