package com.android.homework.timemanagement.interactor.event;

public class DeleteTodoEvent {
    private int code;
    private Throwable throwable;

    public DeleteTodoEvent() { }

    public DeleteTodoEvent(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
