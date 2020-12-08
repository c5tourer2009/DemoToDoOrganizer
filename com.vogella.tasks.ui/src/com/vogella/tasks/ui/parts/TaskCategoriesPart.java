package com.vogella.tasks.ui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
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
import com.vogella.tasks.common.factories.NavigationItemFactory;
import com.vogella.tasks.common.impl.OrganizerDataAccessor;
import com.vogella.tasks.common.interfaces.IOrganizerDataAccessor;
import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.dataAbstraction.INamed;
import com.vogella.tasks.common.interfaces.navigation.INavigationItem;

public class TaskCategoriesPart {
	
	private IOrganizerDataAccessor dataManager;
	private final TreeViewer treeViewer;
	
	@Inject
	@Optional
	private ESelectionService selectionService;
	
	@Inject
	public TaskCategoriesPart(Composite parent) {
		treeViewer = new TreeViewer(parent);
		treeViewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if(element instanceof INamed) {
					return ((INamed) element).getName();
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
					return  (IObservable) ((IToDoList) target).getCategories();
				}
				return null;
			}
		};
		
		TreeStructureAdvisor advisor = new TreeStructureAdvisor() { 
			
		};
		
		treeViewer.setContentProvider(new ObservableListTreeContentProvider<Object>(factory, advisor));
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				
				if(selectionService != null) {
					Object selectedItem = ((IStructuredSelection)event.getSelection()).getFirstElement();
					INavigationItem navigationItem = NavigationItemFactory.create(
							selectedItem, 
							dataManager.getToDoList());
					
					selectionService.setSelection(navigationItem);
				}
			}
		});
	}
	
	@PostConstruct
	public void init() {
		dataManager = new OrganizerDataAccessor();
		WritableList<IToDoList> sourceList = new WritableList<IToDoList>();
		sourceList.add(dataManager.getToDoList());
		treeViewer.setInput(sourceList);
	}
}
