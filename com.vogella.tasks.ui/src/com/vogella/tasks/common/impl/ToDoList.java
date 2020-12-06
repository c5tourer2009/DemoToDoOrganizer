package com.vogella.tasks.common.impl;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.util.List;
import org.eclipse.core.databinding.observable.list.WritableList;

import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;

public class ToDoList extends NotificationObject implements IToDoList {

	public static final String FIELD_CATEGORY_LIST = "categoryList";
	public static final String FIELD_NAME = "name";
	
	private String name;
	private final WritableList<ITaskCategory> categoryList;
	
	public ToDoList() {
		categoryList = new WritableList<>();
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
	public List<ITaskCategory> getCategories() {
		return categoryList;
	}
	
	public void add(ITaskCategory category) {
		categoryList.add(category);
		firePropertyChange(new IndexedPropertyChangeEvent(this, FIELD_CATEGORY_LIST, null, categoryList, categoryList.size() - 1));
	}
	
	public void remove(ITaskCategory category) {
		categoryList.remove(category);
		firePropertyChange(new IndexedPropertyChangeEvent(this, FIELD_CATEGORY_LIST, null, categoryList, categoryList.size() - 1));
	}
}
