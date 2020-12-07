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
	
	public static IToDoList createDemoToDoList(String toDoListName) {
		IToDoList toDoList = new ToDoList();
		toDoList.setName(toDoListName);
		
		ITaskCategory taskCategory = new TaskCategory();
		taskCategory.setName("Shopping");
		toDoList.add(taskCategory);
		
		for (ITask task : createInitialDataModel(taskCategory.getName())) {
			try {
				taskCategory.add(task);
			} catch (OperationNotSupportedException e) {
				e.printStackTrace();
			}
		}
		
		return toDoList;
	}
	
	private static List<ITask> createInitialDataModel(String categoryName) {
		ITask task1 = new Task();
		task1.setTitle(categoryName + "Task 1");
		task1.setDescription("Media Markt: Monitor 28'");
		task1.setPriority(TaskPriority.LOW);
		task1.setStatus(TaskStatus.NOT_DONE);
		try {
			task1.setDueDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-12-31 20:20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ITask task2 = new Task();
		task2.setTitle(categoryName + "Task 2");
		task2.setDescription("Merkur: Milk");
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
