package com.vogella.tasks.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import com.vogella.tasks.common.interfaces.IToDoList;

public class OperationOnToDoListHandlerBase extends SelectionHandlerBase {
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		
		if(!super.canExecute(partService)) {
			return false;
		}
		
		if(getNavigationItem().getSelectedItem() instanceof IToDoList) {
			return true;
		}
		
		return false;
	}
}
