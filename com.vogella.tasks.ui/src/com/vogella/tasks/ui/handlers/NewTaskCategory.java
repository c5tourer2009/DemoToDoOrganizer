package com.vogella.tasks.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.widgets.Shell;

import com.vogella.tasks.common.impl.TaskCategory;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;

public class NewTaskCategory extends OperationOnToDoListHandlerBase {

	@Execute
    public void execute(IWorkbench workbench, Shell shell) {
		ITaskCategory taskCategory = new TaskCategory();
		taskCategory.setName("New Category");
	
		IToDoList toDoList = (IToDoList) getNavigationItem().getSelectedItem();
		toDoList.getCategories().add(taskCategory);
    }
}
