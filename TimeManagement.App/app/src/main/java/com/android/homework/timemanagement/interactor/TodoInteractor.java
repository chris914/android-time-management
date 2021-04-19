package com.android.homework.timemanagement.interactor;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.event.GetTodoEvent;
import com.android.homework.timemanagement.model.Task;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class TodoInteractor {

    public TodoInteractor() {
        TimeManagementApplication.injector.inject(this);
    }
    private List<Task> tasks;

    public void getTasks()
    {
        // Mock list.
        tasks = new ArrayList<>();

        Task testTask = new Task();
        testTask.setId("0");
        testTask.setContent("Test Task");
        testTask.setPriority(2);
        Task testTask2 = new Task();
        testTask2.setId("1");
        testTask2.setContent("Test Task 2");
        testTask2.setPriority(1);

        tasks.add(testTask);
        tasks.add(testTask2);

        GetTodoEvent event = new GetTodoEvent();
        event.setTasks(tasks);
        EventBus.getDefault().post(event);
    }

    public void getTask(int todoId)
    {
        // get single task, send it via eventbus
    }

    public void deleteTask(int todoId)
    {

    }

    public void getCommentsForTask(int todoId)
    {

    }

    public void addCommentForTask(int todoId, String commentText)
    {

    }
}
