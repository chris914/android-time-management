package com.android.homework.timemanagement.ui.details;

public interface TodoDetailsScreen {
    void changeEditMode(boolean editMode);
    void showInCalendar();
    void loadComments();
    void callbackAfterDeleteTask();
}
