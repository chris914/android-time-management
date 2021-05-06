package com.android.homework.timemanagement.interactor.event;

public class UpdateTodoEvent {
    private int code;
    private Throwable throwable;

    public UpdateTodoEvent() { }

    public UpdateTodoEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
