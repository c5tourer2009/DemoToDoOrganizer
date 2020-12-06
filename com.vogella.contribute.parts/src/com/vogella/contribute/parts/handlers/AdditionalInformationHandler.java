package com.vogella.contribute.parts.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

public class AdditionalInformationHandler {
	@Execute
    public void execute() {
      System.out.println((this.getClass().getSimpleName() + " called"));
    }
}
