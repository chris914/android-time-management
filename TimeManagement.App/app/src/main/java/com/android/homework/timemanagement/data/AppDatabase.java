package com.android.homework.timemanagement.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteTodo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context)
    {
        if (instance == null)
            instance = Room.databaseBuilder(context, AppDatabase.class, "tasks").build();

        return instance;
    }
}

