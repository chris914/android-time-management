package com.android.homework.timemanagement.data;

import com.android.homework.timemanagement.model.Task;

import java.util.List;

public class QueryFavoritesEvent {
        private List<FavoriteTodo> favs;

        public QueryFavoritesEvent() { }

        public QueryFavoritesEvent(List<FavoriteTodo> favs) {
            this.favs = favs;
        }

        public List<FavoriteTodo> getTasks() {
            return favs;
        }

        public void setTasks(List<FavoriteTodo> favs) {
            this.favs = favs;
        }
}
