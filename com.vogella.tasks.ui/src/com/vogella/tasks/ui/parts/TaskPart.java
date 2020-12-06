package com.vogella.tasks.ui.parts;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.TaskPriority;
import com.vogella.tasks.common.interfaces.TaskStatus;

public class TaskPart {

	private final DataBindingContext dataBindingContext;
	private final ObservablesManager observablesManager;
	private WritableValue<ITask> task;
	
	@Inject
	public TaskPart(final Composite composite, @Optional final IStylingEngine stylingEngine) {
		dataBindingContext = new DataBindingContext();
		observablesManager = new ObservablesManager();
		task = new WritableValue<>();
		
		observablesManager.runAndCollect(new Runnable() {
			
			@Override
			public void run() {
				initializeUiComponents(composite, stylingEngine);
			}
		});
	}
	
	private void initializeUiComponents(Composite composite, IStylingEngine stylingEngine) {
		Composite parent = new Composite(composite, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		parent.setLayout(gridLayout);
		
		Composite header = new Composite(parent, SWT.NONE);
		header.setLayout(new GridLayout(2, false));
		header.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		if(stylingEngine != null ) {
			stylingEngine.setClassname(header, "taskHeader");	
		}
				
		Label label = new Label(header, SWT.BOLD);
		label.setText("Title");
		
		Text taskTitleText = new Text(header, SWT.BORDER);
		taskTitleText.setLayoutData(new GridData(GridData.FILL_BOTH));
		taskTitleText.setEditable(true);
		dataBindingContext.bindValue(
				WidgetProperties.text(SWT.Modify).observe(taskTitleText), 
				BeanProperties.value("title").observeDetail(task));
		
		label = new Label(header, SWT.NONE);
		label.setText("Status");
				
		ComboViewer comboViewer = new ComboViewer(header, SWT.READ_ONLY | SWT.DROP_DOWN);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new ColumnLabelProvider() {
		    public String getText(Object element) {
		    	TaskStatus status = (TaskStatus) element;
		        return status.getDisplayText();
		    };
		});
		comboViewer.setInput(TaskStatus.class.getEnumConstants());
		
		//CRITICAL CODE
		/**label = new Label(parent, SWT.BORDER);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		IObservableValue target = WidgetProperties.text().observe(label);
		IViewerObservableValue selectedStatus = ViewerProperties.singleSelection().observe(comboViewer);
		// observe the summary attribute of the selection
		IObservableValue detailValue =
				BeanProperties
		        .value("status", TaskStatus.class)
		        .observeDetail(selectedStatus);

		dataBindingContext.bindValue(target, detailValue);*/
		//CRITICAL CODE
		
		
		label = new Label(header,SWT.NONE);
		label.setText("Priority");
		
		comboViewer = new ComboViewer(header, SWT.READ_ONLY | SWT.DROP_DOWN);
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new ColumnLabelProvider() {
		    public String getText(Object element) {
		    	TaskPriority status = (TaskPriority) element;
		        return status.getDisplayText();
		    };
		});
		comboViewer.setInput(TaskPriority.class.getEnumConstants());
		
		//TODO BINDINGS
		
		label = new Label(header,SWT.NONE);
		label.setText("Due Date");
		
        DateTime dateD = new DateTime(header, SWT.DATE | SWT.DROP_DOWN);
		//TODO BINDINGS
        
        Text taskDescription = new Text(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);
		taskDescription.setLayoutData(new GridData(GridData.FILL_BOTH));
		taskDescription.setEditable(true);
		dataBindingContext.bindValue(
				WidgetProperties.text(SWT.Modify).observe(taskDescription), 
				BeanProperties.value("description").observeDetail(task));
	}
	
	@Inject
	public void setTask(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional ITask task) {
		if(task == null) {
			return;
		}
		
		this.task.setValue(task);
	}
	
	@PreDestroy
	public void Dispose() {
		observablesManager.dispose();
	}
}
