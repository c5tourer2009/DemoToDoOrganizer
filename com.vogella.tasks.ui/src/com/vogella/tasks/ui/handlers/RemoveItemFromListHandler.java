package com.vogella.tasks.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.vogella.tasks.common.interfaces.collections.ICustomList;

public class RemoveItemFromListHandler extends OperationOnListItemHandlerBase {
	
	@Execute
    public void execute(IWorkbench workbench, Shell shell) {
		
		Object selectedItem = getNavigationItem().getSelectedItem();
		
		if(parentList instanceof ICustomList<?>) {
			boolean itemIsUse = ((ICustomList<?>) parentList).IsInUse(selectedItem);
			
			if(itemIsUse && !MessageDialog.openQuestion(shell, "Question", "The selected item is in use. Do you want to continue?"))
			{
				return;
			}
		}
		
		parentList.remove(getNavigationItem().getSelectedItem());
    }
}
