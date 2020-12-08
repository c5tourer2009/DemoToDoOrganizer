package com.vogella.tasks.ui.providers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.vogella.tasks.common.interfaces.dataAbstraction.INamed;

public class TreeModelLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getText(Object element) {
		
		if(element instanceof INamed) {
			return ((INamed) element).getName();
		}
		
		return super.getText(element);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		return null;
	}
}
