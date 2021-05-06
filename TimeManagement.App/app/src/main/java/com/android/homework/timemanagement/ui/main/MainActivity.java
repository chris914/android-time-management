package com.android.homework.timemanagement.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.data.FavoriteTodo;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.ui.NavigationSupportedActivity;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showTodos(List<Task> tasks, List<FavoriteTodo> favorites) {
        LinearLayout mainLayout = ((LinearLayout) findViewById(R.id.linearLayoutTodos));
        mainLayout.removeAllViews();
        for (Task t : tasks) {

            // ANTIPATTERN: just for the sake of testing, recyclerview, adapter will be used.

            LayoutInflater inflater = getLayoutInflater();
            View todoItem = inflater.inflate(R.layout.todoitem, mainLayout, false);
            TextView text = (TextView)todoItem.findViewById(R.id.info_text);
            text.setText(t.getContent());
            ImageView favIcon = (ImageView)todoItem.findViewById(R.id.favorite);
            favIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainPresenter.addToFavorite(t.getId());
                }
            });
            boolean isFavorite = favorites.stream().anyMatch(f -> f.uid == t.getId());
            if (isFavorite)
                favIcon.setImageResource(R.drawable.ic_baseline_star_24);

            mainLayout.addView(todoItem);
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
