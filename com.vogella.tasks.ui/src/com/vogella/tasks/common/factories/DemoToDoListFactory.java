package com.vogella.tasks.common.factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import com.vogella.tasks.common.impl.Task;
import com.vogella.tasks.common.impl.TaskCategory;
import com.vogella.tasks.common.impl.ToDoList;
import com.vogella.tasks.common.interfaces.ITask;
import com.vogella.tasks.common.interfaces.ITaskCategory;
import com.vogella.tasks.common.interfaces.IToDoList;
import com.vogella.tasks.common.interfaces.TaskPriority;
import com.vogella.tasks.common.interfaces.TaskStatus;

public class DemoToDoListFactory {
	
	public static IToDoList createDemoToDoList() {
		IToDoList toDoList = new ToDoList();
		toDoList.setName("Private");
		
		ITaskCategory taskCategory = new TaskCategory();
		taskCategory.setName("SSI Schäfer");
		toDoList.add(taskCategory);
		
		for (ITask task : createInitialDataModel()) {
			try {
				taskCategory.add(task);
			} catch (OperationNotSupportedException e) {
				e.printStackTrace();
			}
		}
		
		return toDoList;
	}
	
	private static List<ITask> createInitialDataModel() {
		ITask task1 = new Task();
		task1.setTitle("Task 1");
		task1.setDescription("bla bla bla");
		task1.setStatus(TaskStatus.NOT_DONE);
		try {
			task1.setDueDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-12-31 20:20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ITask task2 = new Task();
		task2.setTitle("Task 2");
		task2.setDescription("blu blub blub");
		task2.setPriority(TaskPriority.LOW);
		task2.setStatus(TaskStatus.NOT_DONE);
		try {
			task2.setDueDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-12-30 12:20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(task1, task2);
	}
}
