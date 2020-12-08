package com.vogella.tasks.common.impl.navigation;

import java.util.List;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.navigation.ITaskNavigationItem;

public class TaskNavigationItem extends SelectedItemNavigationItem<ITask> implements ITaskNavigationItem {

	private final List<ITaskCategory> taskCategories;
	
	public TaskNavigationItem(ITask selectedItem, List<ITaskCategory> taskCategories) {
		super(selectedItem);
		
		this.taskCategories = taskCategories;
	}

	@Override
	public List<ITaskCategory> getCategories() {
		return taskCategories;
	}
}
