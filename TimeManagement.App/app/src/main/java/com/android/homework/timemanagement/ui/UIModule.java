package com.android.homework.timemanagement.ui;

import android.content.Context;

import com.android.homework.timemanagement.data.DatabaseManager;
import com.android.homework.timemanagement.interactor.CommentInteractor;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.ui.details.TodoDetailsPresenter;
import com.android.homework.timemanagement.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(TodoInteractor todoInteractor) {
        return new MainPresenter(todoInteractor);
    }

    @Provides
    @Singleton
    public TodoDetailsPresenter provideTodoDetailsPresenter(TodoInteractor todoInteractor, CommentInteractor commentInteractor) {
        return new TodoDetailsPresenter(todoInteractor, commentInteractor);
    }

    @Provides
    @Singleton
    public DatabaseManager provideDatabaseManager() {
        return new DatabaseManager(context);
    }
}
