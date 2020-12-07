package com.vogella.tasks.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import com.vogella.tasks.common.impl.DataManager;
import com.vogella.tasks.common.interfaces.IDataManager;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;

public class TaskContainerPart {
	
	private IDataManager dataManager;
	private final TreeViewer treeViewer;
	
	@Inject
	@Optional
	private ESelectionService selectionService;
	
	@Inject
	public TaskContainerPart(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if(element instanceof IToDoList) {
					return ((IToDoList) element).getName();
				} else if(element instanceof ITaskCategory) {
					return ((ITaskCategory) element).getName();
				}
				
				return super.getText(element);
			}
		});
		
		IObservableFactory factory = new IObservableFactory() {
			private IListProperty prop = BeanProperties.list("categories");
			
			public IObservable createObservable(Object target) {
				if(target instanceof IObservableList) {
					return (IObservable) target;
				} else if(target instanceof IToDoList) {
					return prop.observe(target);
				}
				return null;
			}
		};
		
		TreeStructureAdvisor advisor = new TreeStructureAdvisor() { 
			@Override
			public Object getParent(Object element) {
		           return "";
		    }
			
			@Override
		    public Boolean hasChildren(Object element) {
				if(element instanceof IToDoList){
					IToDoList folder = (IToDoList)element;
					return !folder.getCategories().isEmpty();
		        }
				
				return false;
			}
			
			
		};
		
		treeViewer.setContentProvider(new ObservableListTreeContentProvider(factory, advisor));
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				if(selectionService != null ) {
					selectionService.setSelection(((IStructuredSelection)event.getSelection()).getFirstElement());
				}
			}
		});
	}
	
	@PostConstruct
	public void init() {
		dataManager = new DataManager();
		treeViewer.setInput(dataManager.getToDoLists());
	}
}
