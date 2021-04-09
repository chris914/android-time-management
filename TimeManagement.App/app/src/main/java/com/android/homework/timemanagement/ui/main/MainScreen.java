package com.android.homework.timemanagement.ui.main;

import com.android.homework.timemanagement.model.Task;

import java.util.List;

public interface MainScreen {
    void callbackAfterToastShown(String text);
    void showTodos(List<Task> tasks);
}
