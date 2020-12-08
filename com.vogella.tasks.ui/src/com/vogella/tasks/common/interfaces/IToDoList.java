package com.vogella.tasks.common.interfaces;

import java.util.List;

public interface IToDoList {
	
	String getName();
	
	void setName(String name);
	
	List<ITaskCategory> getCategories();
	
	List<ITask> getTasks();
}
