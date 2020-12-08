package com.vogella.tasks.common.impl;

import java.beans.PropertyChangeEvent;
import java.util.List;
import com.vogella.tasks.common.impl.collections.CustomList;
import com.vogella.tasks.common.impl.collections.TaskCategoryList;
import com.vogella.tasks.common.impl.dataAbstraction.NotificationObject;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.dataAbstraction.INamed;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwner;

public class ToDoList extends NotificationObject implements IToDoList, INamed, IOwner {

	public static final String FIELD_NAME = "name";
		
	private final ToDoListController toDoListController;
	private final TaskCategoryList categoryList;
	private final CustomList<ITask> taskList;
	private String name;
	
	public ToDoList() {
		toDoListController = new ToDoListController(this);
		categoryList = new TaskCategoryList(this, toDoListController);
		taskList = new CustomList<ITask>();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_NAME, this.name, this.name = name));
	}

	@Override
	public List<ITaskCategory> getCategories() {
		return categoryList;
	}
	
	@Override
	public List<ITask> getTasks() {
		return taskList;
	}
}
