package com.vogella.tasks.common.interfaces;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;

public interface IItemManager<T> extends IObservableList<T> {
	
	String getName();
	
	void setName(String name);
	
	List<T> getChildren();
}
