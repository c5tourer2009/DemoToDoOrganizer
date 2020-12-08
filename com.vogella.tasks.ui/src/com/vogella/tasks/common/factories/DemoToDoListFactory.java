package com.vogella.tasks.common.factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
		
		ITaskCategory newCategory = AddNewCategoryTo(toDoList, "Shooping");
		AddDemoTasksToCategory(toDoList, newCategory);
		
		newCategory = AddNewCategoryTo(toDoList, "FH Campus 02");
		AddDemoTasksToCategory(toDoList, newCategory);
		
		return toDoList;
	}
	
	private static ITaskCategory AddNewCategoryTo(IToDoList toDoList, String categroyName) {
		ITaskCategory taskCategory = new TaskCategory();
		taskCategory.setName(categroyName);
		toDoList.getCategories().add(taskCategory);
		return taskCategory;
	}
	
	private static void AddDemoTasksToCategory(IToDoList toDoList, ITaskCategory category) {
		for (ITask task : createInitialTasksFor(category)) {
			toDoList.getTasks().add(task);
		}		
	}
	
	private static List<ITask> createInitialTasksFor(ITaskCategory taskCategory) {
		ITask task1 = new Task();
		task1.setTitle(taskCategory.getName() + " - Task 1");
		task1.setDescription("Media Markt: Monitor 28'");
		task1.setPriority(TaskPriority.LOW);
		task1.setStatus(TaskStatus.NOT_DONE);
		task1.setCategory(taskCategory);
		try {
			task1.setDueDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-12-31 20:20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ITask task2 = new Task();
		task2.setTitle(taskCategory.getName() + " - Task 2");
		task2.setDescription("Merkur: Milk");
		task2.setPriority(TaskPriority.LOW);
		task2.setStatus(TaskStatus.NOT_DONE);
		task2.setCategory(taskCategory);
		try {
			task2.setDueDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-12-30 12:20"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(task1, task2);
	}
}
