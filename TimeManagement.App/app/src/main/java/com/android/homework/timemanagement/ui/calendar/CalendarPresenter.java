package com.android.homework.timemanagement.ui.calendar;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.ui.Presenter;
import com.android.homework.timemanagement.ui.details.TodoDetailsScreen;

import java.util.Date;

import javax.inject.Inject;

public class CalendarPresenter extends Presenter<CalendarScreen> {
    private final TodoInteractor todoInteractor;

    @Inject
    public CalendarPresenter(TodoInteractor todoInteractor)
    {
        this.todoInteractor = todoInteractor;
    }

    @Override
    public void attachScreen(CalendarScreen screen) {
        super.attachScreen(screen);
        TimeManagementApplication.injector.inject(this);
        // EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        // EventBus.getDefault().unregister(this);
    }

    public void loadTodos(Date startDate, Date endDate)
    {
        todoInteractor.getTasks(startDate, endDate);

        // eventbus register
        // event arrives in callback function like in MainPresenter.java
        // screen.showTodos(list);
    }

    public void scrollCalendar(int scrollDirection)
    {
        // update dates
        // this.loadTodos

        // callback to screen to refresh calendar header
        screen.scrollCalendar();
    }

    public void openTodo(int todoId)
    {
        // open todo in TodoDetailsActivity
        // callback to screen

        screen.openTodo(todoId);
    }
}
