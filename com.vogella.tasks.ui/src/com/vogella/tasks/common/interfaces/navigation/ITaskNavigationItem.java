package com.vogella.tasks.common.interfaces.navigation;

import java.util.List;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;

public interface ITaskNavigationItem extends ISelectedItemNavigationItem<ITask> {
	
	List<ITaskCategory> getCategories();
}
