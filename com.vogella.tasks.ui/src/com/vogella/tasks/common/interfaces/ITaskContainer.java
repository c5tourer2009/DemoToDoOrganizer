package com.vogella.tasks.common.interfaces;

import java.util.List;

public interface ITaskContainer {
	
	ITaskContainer getParent();
	
	List<ITask> getTasks();
	
	void setParent(ITaskContainer container);
}
