package com.vogella.tasks.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import com.vogella.tasks.common.interfaces.ITask;

public class EditTaskHandlerBase extends EditSelectionHandlerBase {
	
	protected EditTaskHandlerBase() {
		
	}
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		
		if(!super.canExecute(partService)) {
			return false;
		}
		
		if(getCurrentSelection().getValue() instanceof ITask) {
			return true;
		}
		
		return false;
	}
}
