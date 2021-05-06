package com.android.homework.timemanagement.interactor.event;

import com.android.homework.timemanagement.model.Task;

public class AddTodoEvent {
    private int code;
    private Task task;
    private Throwable throwable;

    public AddTodoEvent() { }

    public AddTodoEvent(int code, Task task) {
        this.code = code;
        this.task = task;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
