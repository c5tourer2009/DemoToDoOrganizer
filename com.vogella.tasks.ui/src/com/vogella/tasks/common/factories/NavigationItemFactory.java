package com.vogella.tasks.common.factories;

import java.util.List;
import com.vogella.tasks.common.impl.navigation.OrganizerNavigationItem;
import com.vogella.tasks.common.impl.navigation.TaskNavigationItem;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.navigation.IOrganizerNavigationItem;
import com.vogella.tasks.common.interfaces.navigation.ITaskNavigationItem;

public class NavigationItemFactory {
	
	private NavigationItemFactory() {
	}
	
	public static IOrganizerNavigationItem create(Object selectedItem, IToDoList toDoList) {
		return new OrganizerNavigationItem(selectedItem, toDoList);
	}
	
	public static ITaskNavigationItem create(ITask task, List<ITaskCategory> taskCategories) {
		return new TaskNavigationItem(task, taskCategories);
	}
}
