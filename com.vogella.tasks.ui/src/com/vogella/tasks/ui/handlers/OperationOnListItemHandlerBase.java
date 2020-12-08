package com.vogella.tasks.ui.handlers;

import java.util.List;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwner;
import com.vogella.tasks.common.interfaces.dataAbstraction.IOwnerNotificationObject;

public class OperationOnListItemHandlerBase extends SelectionHandlerBase {

	protected List parentList;
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		
		if(!super.canExecute(partService)) {
			return false;
		}
		
		Object object = getNavigationItem().getSelectedItem();
		
		if(object instanceof IOwnerNotificationObject) {
			IOwner owner = ((IOwnerNotificationObject) object).getOwner();
			
			if(owner instanceof List) {
				parentList = (List) owner;
				return true;
			}
		}
		
		return false;
	}
}
