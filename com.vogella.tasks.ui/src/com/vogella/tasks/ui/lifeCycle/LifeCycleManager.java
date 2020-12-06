package com.vogella.tasks.ui.lifeCycle;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessRemovals;

@SuppressWarnings("restriction")
public class LifeCycleManager {
	
	@PostContextCreate
	void postContextCreate(IEclipseContext workbenchContext) {
		
	}

	@PreSave
	void preSave(IEclipseContext workbenchContext) {
		
	}

	@ProcessAdditions
	void processAdditions(IEclipseContext workbenchContext) {
		
	}

	@ProcessRemovals
	void processRemovals(IEclipseContext workbenchContext) {
		
	}
}
