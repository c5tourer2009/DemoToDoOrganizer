package com.vogella.tasks.ui.handlers;

import javax.naming.OperationNotSupportedException;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import com.vogella.tasks.common.impl.Task;
import com.vogella.tasks.common.interfaces.ITask;

public class NewTaskHandler extends EditTaskHandlerBase {
	
	@Execute
    public void execute(IEclipseContext context) {
		ITask newTask = new Task();
		newTask.setTitle("New Task");
		
        try {
			((ITask) getCurrentSelection().getValue()).getCategory().add(newTask);
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		}
    }
}
