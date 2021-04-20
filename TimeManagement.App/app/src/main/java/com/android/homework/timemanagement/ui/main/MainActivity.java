package com.android.homework.timemanagement.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.ui.NavigationSupportedActivity;
import com.android.homework.timemanagement.ui.ToastManager;
import com.android.homework.timemanagement.ui.details.TodoDetailsActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends NavigationSupportedActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_main, fl);
        TimeManagementApplication.injector.inject(this);

        findViewById(R.id.btnLoadTodos).setOnClickListener(v -> {
            mainPresenter.loadTodoList();
        });

        findViewById(R.id.btnAddTodo).setOnClickListener(v -> {
            mainPresenter.addNewTodo();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void callbackAfterToastShown(String text) {
        // do something with 'text'...
    }

    @Override
    public void showTodos(List<Task> tasks) {
        for (Task t : tasks) {

            // ANTIPATTERN: just for the sake of testing, recyclerview, adapter will be used.
            ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextView tv = new TextView(this);
            tv.setTextColor(Color.WHITE);
            tv.setLayoutParams(lparams);
            tv.setText("ID: " + t.getId() + " Content: " + t.getContent());
            tv.setOnClickListener(v -> {
                mainPresenter.openTodo(0);
            });
            ((LinearLayout) findViewById(R.id.linearLayoutTodos)).addView(tv);
        }
    }

    @Override
    public void addTodo() {
        Intent i = new Intent(this, TodoDetailsActivity.class);
        this.startActivity(i);
    }

    @Override
    public void openTodoScreen(int todoId) {

    }
}
