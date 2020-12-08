package com.vogella.tasks.common.interfaces.collections;

import org.eclipse.core.databinding.observable.list.IObservableList;

public interface ICustomList<E> extends IObservableList<E> {
	
	boolean IsInUse(Object element);
}
