package com.android.homework.timemanagement.ui.calendar;

import com.android.homework.timemanagement.model.Task;

import java.util.List;

public interface CalendarScreen {
    void showTodos(List<Task> tasks);
    void scrollCalendar();
    void openTodo(int todoId);
}
