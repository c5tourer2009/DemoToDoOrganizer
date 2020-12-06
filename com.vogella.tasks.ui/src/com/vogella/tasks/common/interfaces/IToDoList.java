package com.vogella.tasks.common.interfaces;

import java.util.List;

public interface IToDoList {
	
	String getName();
	
	void setName(String name);
	
	void add(ITaskCategory category);
	
	void remove(ITaskCategory category);
	
	List<ITaskCategory> getCategories();
}
