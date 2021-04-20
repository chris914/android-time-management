package com.android.homework.timemanagement.ui.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.ui.NavigationSupportedActivity;

import java.util.List;

import javax.inject.Inject;

public class CalendarActivity extends NavigationSupportedActivity implements CalendarScreen {

    @Inject
    CalendarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_calendar, fl);
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
    public void showTodos(List<Task> tasks) {

    }

    @Override
    public void scrollCalendar() {

    }

    @Override
    public void openTodo(int todoId) {

    }
}