package com.vogella.tasks.common.interfaces;

import javax.naming.OperationNotSupportedException;

public interface ITaskCategory extends ITaskContainer {
	
	String getName();
	
	void setName(String name);
	
    void add(ITask task) throws OperationNotSupportedException;
	
	void remove(ITask task) throws OperationNotSupportedException;
}
