package com.vogella.tasks.common.impl;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.eclipse.core.databinding.observable.list.WritableList;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.ITaskContainer;

public class TaskCategory extends NotificationObject implements ITaskCategory {

	public static final String FIELD_PARENT = "parent";
	public static final String FIELD_NAME = "name";
	
	private ITaskContainer parent;
	private String name;
	private final WritableList<ITask> taskList;
	
	public TaskCategory() {
		taskList = new WritableList<>();
	}
	
	@Override
	public List<ITask> getTasks() {
		return taskList;
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
	public ITaskContainer getParent() {
		return parent;
	}

	@Override
	public void setParent(ITaskContainer container) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_PARENT, this.parent, this.parent = container));
	}
	
	public void add(ITask task) throws OperationNotSupportedException {
		if(task.getCategory() != null) {
			throw new OperationNotSupportedException("The task is already in a category.");
		}
		
		((Task)task).setCategory(this);
		taskList.add(task);
		firePropertyChange(new IndexedPropertyChangeEvent(this, "taskList", null, taskList, taskList.size() - 1));
	}
	
	public void remove(ITask task) throws OperationNotSupportedException {
		if(task.getCategory() != this) {
			throw new OperationNotSupportedException("The task is already in a category.");
		}
		((Task)task).setCategory(null);
		
		taskList.remove(task);
		firePropertyChange(new IndexedPropertyChangeEvent(this, "taskList", null, taskList, taskList.size() - 1));
	}
}
