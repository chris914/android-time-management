package com.android.homework.timemanagement.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.ui.NavigationSupportedActivity;
import com.android.homework.timemanagement.ui.main.MainPresenter;

import javax.inject.Inject;

public class TodoDetailsActivity extends NavigationSupportedActivity implements TodoDetailsScreen {

    @Inject
    TodoDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_todo_details, fl);
        TimeManagementApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    public void changeEditMode(boolean editMode) {
        // change layout to edit mode layout
    }

    @Override
    public void showInCalendar() {
        // open todo in calendar
    }

    @Override
    public void loadComments() {
        // load comments from api
    }

    @Override
    public void callbackAfterDeleteTask() {
        // task deleted, show previous screen.
    }
}