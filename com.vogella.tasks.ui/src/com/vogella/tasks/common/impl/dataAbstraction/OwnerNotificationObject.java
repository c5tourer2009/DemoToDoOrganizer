package com.vogella.tasks.common.impl.dataAbstraction;

import java.beans.PropertyChangeEvent;

import com.vogella.tasks.common.interfaces.dataAbstraction.IOwner;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwnerNotificationObject;

public class OwnerNotificationObject extends NotificationObject implements IOwnerNotificationObject {

	private IOwner owner;
	
	public IOwner getOwner() {
		return owner;
	}
	
	public void setOwner(IOwner owner) {
		firePropertyChange(new PropertyChangeEvent(this, "owner", this.owner, this.owner = owner));
	}
}
