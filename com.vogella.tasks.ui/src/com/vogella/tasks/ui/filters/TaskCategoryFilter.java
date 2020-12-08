package com.vogella.tasks.ui.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;

public class TaskCategoryFilter extends ViewerFilter {
	
	private final ITaskCategory taskCategory;
	
	public TaskCategoryFilter(ITaskCategory taskCategory) {
		if(taskCategory == null) {
			throw new IllegalArgumentException("The argument taskCategory must not be null");
		}
		this.taskCategory = taskCategory;
	}
	
	@Override
	/**
	 * Returns true to include the object, false to exclude
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element)
	{
		ITask task = (ITask) element;
		
		return task.getCategory() != null && task.getCategory() == taskCategory;
	}
}
