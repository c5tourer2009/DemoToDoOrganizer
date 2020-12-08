package com.vogella.tasks.ui.handlers;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import com.vogella.tasks.common.interfaces.navigation.ISelectedItemNavigationItem;

public class SelectionHandlerBase {
	private WritableValue<ISelectedItemNavigationItem<Object>> selectedItem;
	
	protected ISelectedItemNavigationItem<Object> getNavigationItem() {
		return selectedItem.getValue();
	}
	
	@CanExecute
	public boolean canExecute(EPartService partService) {
		
		if(selectedItem == null) {
			return false;
		}
		
		return true;
	}
	
	@Inject
	public void setTask(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ISelectedItemNavigationItem<Object> item) {
		if(item == null) {
			this.selectedItem = null;
			return;
		}
		
		if(this.selectedItem == null) {
			this.selectedItem = new WritableValue<ISelectedItemNavigationItem<Object>>();
		}
		
		this.selectedItem.setValue(item);
	}
}
