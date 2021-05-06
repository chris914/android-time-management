package com.android.homework.timemanagement.ui.main;

import com.android.homework.timemanagement.data.FavoriteTodo;
import com.android.homework.timemanagement.model.Task;

import java.util.List;

public interface MainScreen {
    void showTodos(List<Task> tasks, List<FavoriteTodo> favorites);
    void addTodo();
    void openTodoScreen(int todoId);
}
