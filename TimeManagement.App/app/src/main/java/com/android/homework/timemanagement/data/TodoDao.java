package com.android.homework.timemanagement.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM favoritetodo")
    List<FavoriteTodo> getAll();

    @Query("SELECT * FROM favoriteTodo WHERE uid=:id")
    FavoriteTodo getFavoriteTodo(long id);

    @Delete
    void delete(FavoriteTodo favoriteTodo);

    @Insert
    void insert(FavoriteTodo favoriteTodo);
}
