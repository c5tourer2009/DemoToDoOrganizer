package com.vogella.contribute.parts.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AdditionalInformationHandler {
	@Execute
    public void execute(Shell shell) {
		
		MessageDialog.openInformation(shell, 
				"Plugin Command", 
				"I am a plugin command");
    }
}
