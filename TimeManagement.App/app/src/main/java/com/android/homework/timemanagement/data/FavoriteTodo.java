package com.android.homework.timemanagement.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoriteTodo")
public class FavoriteTodo {
    @PrimaryKey
    public long uid;
}
