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

    public void getTasks()
    {
        Task testTask = new Task();
        testTask.setId("0");
        testTask.setContent("Test Task");
        Task testTask2 = new Task();
        testTask2.setId("1");
        testTask2.setContent("Test Task 2");

        List<Task> tasks = new ArrayList<>();
        tasks.add(testTask);
        tasks.add(testTask2);

        GetTodoEvent event = new GetTodoEvent();
        event.setTasks(tasks);
        EventBus.getDefault().post(event);
    }
}
