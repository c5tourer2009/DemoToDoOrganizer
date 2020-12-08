package com.vogella.tasks.common.impl;

import java.util.ArrayList;
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
			if(current.getCategory() == taskCategory) {
				return true;
			}
		}
		
		return false;
	}
	
	public void RemoveAllDependencies(ITaskCategory taskCategory) {
		ArrayList<ITask> copyList = new ArrayList<ITask>(toDoList.getTasks());
		
		for(ITask task : copyList) {
			if(task.getCategory() == taskCategory) {
				toDoList.getTasks().remove(task);
				//task.setCategory(null);
			}
		}
	}
}
