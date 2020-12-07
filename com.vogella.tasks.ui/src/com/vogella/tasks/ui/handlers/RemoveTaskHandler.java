package com.vogella.tasks.ui.handlers;

import javax.naming.OperationNotSupportedException;
import org.eclipse.e4.core.di.annotations.Execute;
import com.vogella.tasks.common.interfaces.ITask;

public class RemoveTaskHandler extends EditTaskHandlerBase {

	@Execute
    public void execute() {
        try {
        	ITask taskToRemove = (ITask) getCurrentSelection().getValue();
        	taskToRemove.getCategory().remove(taskToRemove);
        	
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
    }
}
