package com.vogella.tasks.ui.parts;

import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import com.vogella.tasks.common.impl.DataManager;
import com.vogella.tasks.common.interfaces.IDataManager;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.ITaskContainer;
import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.TaskPriority;
import com.vogella.tasks.common.interfaces.TaskStatus;

public class TaskListPart {
	
	private TableViewer tableViewer;
	
	@Inject
	@Optional
	private ESelectionService selectionService;
	
	@Inject
	public TaskListPart(Composite parent, @Optional IStylingEngine styleEngine) {
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.setContentProvider(new ObservableListContentProvider<Object>());
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		
		if(styleEngine != null ) {
			styleEngine.setClassname(this.tableViewer.getControl(), "taskList");
		}
		
		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Title");
		column.getColumn().setWidth(250);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((ITask) element).getTitle();
			}
		});
		
		column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Due Date");
		column.getColumn().setWidth(180);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {			
				return getCellValueFor(((ITask)element).getDueDate());
			}
		});
			
		column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Priority");
		column.getColumn().setWidth(80);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return getCellValueFor(((ITask)element).getPriority());
			}
		});
		
		column = new TableViewerColumn(tableViewer, SWT.NONE);
		column.getColumn().setText("Status");
		column.getColumn().setWidth(90);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return getCellValueFor(((ITask)element).getStatus());
			}
		});
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if(selectionService != null ) {
					Object selection = ((IStructuredSelection)event.getSelection()).getFirstElement();
					selectionService.setSelection(selection);
				}
			}
		});
		
		// Add double click listener
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
		    @Override
		    public void doubleClick(DoubleClickEvent event) {
		        IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();

		        ITask item = (ITask)selection.getFirstElement();
		        
		        MessageDialog.openInformation(parent.getShell(), "Info", item.getTitle());
		    }
		});
		
		
		IDataManager localDataManager = new DataManager();
		tableViewer.setInput(((ITaskCategory)((IToDoList)localDataManager.getToDoLists().get(0)).getCategories().get(0)).getTasks());
		System.out.println(this.getClass().getSimpleName() + " constructed");
	}
	
	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}
	
	@Inject
	public void setContainer(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ITaskContainer taskContainer) {
		if(taskContainer == null) {
			return;
		}
		
		tableViewer.setInput(taskContainer.getTasks());
	}
	
	private String getCellValueFor(Date date) {
		if(date == null) {
			return "";
		}
		
		return date.toString();
	}
	
	private String getCellValueFor(TaskPriority priority) {
		if(priority == null) {
			return "";
		}
		
		return priority.getDisplayText();
	}
	
	private String getCellValueFor(TaskStatus status) {
		if(status == null) {
			return "";
		}
		
		return status.getDisplayText();
	}
}
