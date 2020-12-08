package com.vogella.tasks.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.widgets.Shell;

public class RemoveItemFromListHandler extends OperationOnListItemHandlerBase {
	
	@Execute
    public void execute(IWorkbench workbench, Shell shell) {
		
		parentList.remove(getNavigationItem().getSelectedItem());
    }
}
