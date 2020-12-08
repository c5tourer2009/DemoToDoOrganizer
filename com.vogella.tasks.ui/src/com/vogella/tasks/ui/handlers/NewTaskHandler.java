package com.vogella.tasks.ui.handlers;

import java.util.List;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;
import com.vogella.tasks.common.impl.Task;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.navigation.IOrganizerNavigationItem;

public class NewTaskHandler extends SelectionHandlerBase {
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		
		if(!super.canExecute(partService)) {
			return false;
		}
		
		if(!(getNavigationItem() instanceof IOrganizerNavigationItem)) {
			return false;
		}
		
		var selectedItem = getNavigationItem().getSelectedItem();
		
		return selectedItem instanceof ITaskCategory;
	}
	
	@Execute
    public void execute(IWorkbench workbench, Shell shell) {
		ITask newTask = new Task();
		newTask.setTitle("New Task");
		newTask.setCategory((ITaskCategory) getNavigationItem().getSelectedItem());
		
		List<ITask> taskList = ((IOrganizerNavigationItem) getNavigationItem()).getToDoList().getTasks();
		
		taskList.add(newTask);
    }
}
