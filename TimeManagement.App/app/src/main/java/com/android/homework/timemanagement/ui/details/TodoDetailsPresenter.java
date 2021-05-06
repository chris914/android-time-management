package com.android.homework.timemanagement.ui.details;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.CommentInteractor;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.model.Comment;
import com.android.homework.timemanagement.ui.Presenter;

import javax.inject.Inject;

public class TodoDetailsPresenter extends Presenter<TodoDetailsScreen> {
    private final TodoInteractor todoInteractor;
    private final CommentInteractor commentInteractor;
    private boolean isEditMode;

    @Inject
    public TodoDetailsPresenter(TodoInteractor todoInteractor, CommentInteractor commentInteractor)
    {
        this.todoInteractor = todoInteractor;
        this.commentInteractor = commentInteractor;
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
    }

    public void addComment(Long taskId, String commentText)
    {
        Comment comment = new Comment();
        comment.setContent(commentText);
        comment.setTaskId(taskId);
        commentInteractor.addComment(comment);
    }

    public void showInCalendar()
    {
        screen.showInCalendar();
    }
}