package com.android.homework.timemanagement.interactor.event;

import com.android.homework.timemanagement.model.Task;

public class CloseTodoEvent {
    private int code;
    private Throwable throwable;

    public CloseTodoEvent() { }

    public CloseTodoEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
