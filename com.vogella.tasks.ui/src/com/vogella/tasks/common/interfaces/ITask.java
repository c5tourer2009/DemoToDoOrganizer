package com.vogella.tasks.common.interfaces;

import java.util.Date;

public interface ITask {
	
	/**
	 * Returns the title.
	 * @return
	 */
	String getTitle();
	
	/**
	 * Return the task description.
	 * @return
	 */
	String getDescription();
	
	/**
	 * Returns the due to date.
	 * @return
	 */
	Date getDueDate();
	
	/**
	 * Returns the priority.
	 * @return
	 */
	TaskPriority getPriority();
	
	/**
	 * Returns the status.
	 * @return
	 */
	TaskStatus getStatus();
	
	ITaskCategory getCategory();
	
	void setTitle(String title);
	
	void setDescription(String description);
	
	void setDueDate(Date dueDate);
	
	void setPriority(TaskPriority priority);
	
	void setStatus(TaskStatus status);
	
	void setCategory(ITaskCategory category);
}
