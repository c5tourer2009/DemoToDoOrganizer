package com.vogella.tasks.common.impl;

import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;

public class ToDoListController {
	
	private final IToDoList toDoList;
	
	public ToDoListController(IToDoList toDoList) {
		if(toDoList == null) {
			throw new NullPointerException("The argument accessor must not be null.");
		}
		
		this.toDoList = toDoList;
	}
	
	public boolean IsInUse(ITaskCategory taskCategory) {
		for (ITask current : toDoList.getTasks()) {
			if(current == taskCategory) {
				return true;
			}
		}
		
		return false;
	}
	
	public void RemoveAllDependencies(ITaskCategory taskCategory) {
		for(ITask task : toDoList.getTasks()) {
			if(task.getCategory() == taskCategory) {
				task.setCategory(null);
			}
		}
	}
}
