package com.vogella.tasks.common.impl.collections;

import java.util.Collection;
import com.vogella.tasks.common.impl.ToDoListController;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwner;

public class TaskCategoryList extends CustomList<ITaskCategory> implements IOwner {
	
	private final IOwner owner;
	private final ToDoListController controller;
	
	public TaskCategoryList(IOwner owner, ToDoListController controller) {
		this.owner = owner;
		this.controller = controller;
	}
	
	@Override
	public boolean IsInUse(Object element) {
		return controller.IsInUse((ITaskCategory) element);
	}
	
	@Override
	public ITaskCategory remove(int index) {
		ITaskCategory category = get(index); 
		controller.RemoveAllDependencies(category);	
		return super.remove(index);
	}

	@Override
	public boolean remove(Object object) {
		controller.RemoveAllDependencies((ITaskCategory) object);
		return super.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		for (Object object : collection) {
			controller.RemoveAllDependencies((ITaskCategory) object);
		}
		return super.removeAll(collection);
	}
}
