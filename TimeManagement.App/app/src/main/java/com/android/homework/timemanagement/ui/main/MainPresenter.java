package com.android.homework.timemanagement.ui.main;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.interactor.event.GetTodoEvent;
import com.android.homework.timemanagement.ui.Presenter;
import com.android.homework.timemanagement.ui.ToastManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    ToastManager toastManager;
    TodoInteractor todoInteractor;

    @Inject
    public MainPresenter(ToastManager toastManager, TodoInteractor todoInteractor)
    {
        this.toastManager = toastManager;
        this.todoInteractor = todoInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        TimeManagementApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void addNewTodo()
    {
        // callback to screen, as this requires invoking a new activity.
        screen.addTodo();
    }

    public void openTodo(int todoId)
    {
        todoInteractor.getTask(todoId);

        // callback to screen, as this requires invoking a new activity.
        screen.openTodoScreen(todoId);
    }

    public void loadTodoList()
    {
        todoInteractor.getTasks();
    }

    public void makeToast(String text)
    {
        toastManager.makeText(text);
        screen.callbackAfterToastShown(text);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTodoEvent event) {
        if (screen != null) {
                screen.showTodos(event.getTasks());
            }
    }
}
