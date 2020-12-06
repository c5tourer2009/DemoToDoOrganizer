package com.vogella.tasks.common.impl;

import java.beans.PropertyChangeEvent;
import java.util.Date;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.TaskPriority;
import com.vogella.tasks.common.interfaces.TaskStatus;

public class Task extends NotificationObject implements ITask {
	
	public static final String FIELD_TITLE = "title";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_DUEDATE = "dueDate";
    public static final String FIELD_PRIORITY = "priority";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_CATEGORY = "category";

	private String title;
	private String description;
	private Date dueDate;
	private TaskPriority priority;
	private TaskStatus status;
	private ITaskCategory category;
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Date getDueDate() {
		return dueDate;
	}

	@Override
	public TaskPriority getPriority() {
		return priority;
	}

	@Override
	public TaskStatus getStatus() {
		return status;
	}

	@Override
	public ITaskCategory getCategory() {
		return category;
	}

	@Override
	public void setTitle(String title) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_TITLE, this.title, this.title = title));
	}

	@Override
	public void setDescription(String description) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_DESCRIPTION, this.description, this.description = description));
	}
	
	@Override
	public void setDueDate(Date dueDate) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_DUEDATE, this.dueDate, this.dueDate = dueDate));
	}

	@Override
	public void setPriority(TaskPriority priority) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_PRIORITY, this.priority, this.priority = priority));
	}

	@Override
	public void setStatus(TaskStatus status) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_STATUS, this.status, this.status = status));
	}
	
	public void setCategory(ITaskCategory category) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_CATEGORY, this.category, this.category = category));
	}
}
