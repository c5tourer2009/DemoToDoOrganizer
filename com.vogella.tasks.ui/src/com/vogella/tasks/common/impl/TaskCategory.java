package com.vogella.tasks.common.impl;

import java.beans.PropertyChangeEvent;
import com.vogella.tasks.common.impl.dataAbstraction.OwnerNotificationObject;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.dataAbstraction.INamed;

public class TaskCategory extends OwnerNotificationObject implements ITaskCategory, INamed {

	public static final String FIELD_NAME = "name";
	
	private String name;
	
	public TaskCategory() {
		
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		firePropertyChange(new PropertyChangeEvent(this, FIELD_NAME, this.name, this.name = name));
	}
}
