package com.vogella.tasks.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import com.vogella.tasks.common.interfaces.ITask;

public class EditTaskHandlerBase {
	
	private WritableValue<ITask> task;
	
	protected EditTaskHandlerBase() {
		
	}
	
	protected WritableValue<ITask> getCurrentSelection() {
		return task;
	}
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		if(task == null) {
			return false;
		}
		return true;
	}
	
	@Inject
	public void setTask(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ITask task) {
		if(task == null) {
			this.task = null;
			return;
		}
		
		if(this.task == null) {
			this.task = new WritableValue<ITask>();
		}
		
		this.task.setValue(task);
	}
}
