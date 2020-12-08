package com.vogella.tasks.common.impl.collections;

import java.util.Collection;
import org.eclipse.core.databinding.observable.list.WritableList;
import com.vogella.tasks.common.interfaces.collections.ICustomList;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwner;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwnerNotificationObject;

public class CustomList<T> extends WritableList<T> implements ICustomList<T>, IOwner {

	@Override
	public T remove(int index) {
		Object element = get(index);
		RemoveOwnerFrom(element);
		return super.remove(index);
	}

	public boolean IsInUse(Object element) {
		return false;
	}
	
	@Override
	public boolean add(T element) {
		SetOwnerFor(element);
		return super.add(element);
	}

	@Override
	public void add(int index, T element) {
		SetOwnerFor(element);
		super.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		for (Object object : collection) {
			SetOwnerFor(object);
		}
		return super.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> collection) {
		for (Object object : collection) {
			SetOwnerFor(object);
		}
		return super.addAll(index, collection);
	}

	@Override
	public boolean remove(Object object) {
		RemoveOwnerFrom(object);
		return super.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		for (Object object : collection) {
			RemoveOwnerFrom(object);
		}
		return super.removeAll(collection);
	}

	private void SetOwnerFor(Object object) {
		if(object instanceof IOwnerNotificationObject) {
    		((IOwnerNotificationObject)object).setOwner(this);
		}
	}
	
    private void RemoveOwnerFrom(Object object) {
    	if(object instanceof IOwnerNotificationObject) {
    		((IOwnerNotificationObject)object).setOwner(null);
		}
	}
    
    /**
     * his.addListChangeListener(event -> {
			
			for (ListDiffEntry<?> entry : event.diff.getDifferences()) {
				Object element = entry.getElement();
				
				if(element instanceof IOwnerNotificationObject) {
					if(entry.isAddition()) {
						((IOwnerNotificationObject) element).setOwner((IOwner)event.getObservableList());
					} else {
						((IOwnerNotificationObject) element).setOwner(null);
					}
				}
			}	
		});
     */
}
