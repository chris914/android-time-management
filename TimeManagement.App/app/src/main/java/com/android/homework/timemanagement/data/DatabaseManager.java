package com.android.homework.timemanagement.data;

import android.content.Context;
import android.os.AsyncTask;

import com.android.homework.timemanagement.di.TimeManagementApplication;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class DatabaseManager {
    Context context;

    public DatabaseManager(Context context)
    {
        this.context = context;
        TimeManagementApplication.injector.inject(this);
    }

    public void addToFavorites(long taskId)
    {
        AsyncTask.execute(() -> {
            FavoriteTodo fav = AppDatabase.getInstance(context).todoDao().getFavoriteTodo(taskId);
            if (fav == null)
            {
                FavoriteTodo newFav = new FavoriteTodo(); newFav.uid = taskId;
                AppDatabase.getInstance(context).todoDao().insert(newFav);
            }
            else
                AppDatabase.getInstance(context).todoDao().delete(fav);

            EventBus.getDefault().post(new FavoritesChangedEvent());
        });
    }

    public void getFavorites()
    {
        AsyncTask.execute(() -> {
            List<FavoriteTodo> todos = AppDatabase.getInstance(context).todoDao().getAll();
            QueryFavoritesEvent event = new QueryFavoritesEvent();
            event.setTasks(todos);

            EventBus.getDefault().post(event);
        });
    }
}
