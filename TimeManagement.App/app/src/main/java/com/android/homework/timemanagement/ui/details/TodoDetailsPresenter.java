package com.android.homework.timemanagement.ui.details;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.ui.Presenter;
import com.android.homework.timemanagement.ui.ToastManager;
import com.android.homework.timemanagement.ui.main.MainScreen;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public class TodoDetailsPresenter extends Presenter<TodoDetailsScreen> {
    private final TodoInteractor todoInteractor;
    private boolean isEditMode;

    @Inject
    public TodoDetailsPresenter(TodoInteractor todoInteractor)
    {
        this.todoInteractor = todoInteractor;
        this.isEditMode = false;
    }

    @Override
    public void attachScreen(TodoDetailsScreen screen) {
        super.attachScreen(screen);
        TimeManagementApplication.injector.inject(this);
        // EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        // EventBus.getDefault().unregister(this);
    }

    public void changeEditMode(boolean isEditMode)
    {
        this.isEditMode = isEditMode;
        screen.changeEditMode(isEditMode);
    }

    public void deleteTodo()
    {
        todoInteractor.deleteTask(0);
        screen.callbackAfterDeleteTask();
    }

    public void changePriority(int chosenPriority)
    {
        // prio change
    }

    public void showComments()
    {
        todoInteractor.getCommentsForTask(0);
    }

    public void addComment(String commentText)
    {
        todoInteractor.addCommentForTask(0, commentText);
    }

    public void showInCalendar()
    {
        screen.showInCalendar();
    }
}