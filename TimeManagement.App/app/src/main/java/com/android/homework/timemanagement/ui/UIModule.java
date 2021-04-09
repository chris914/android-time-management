package com.android.homework.timemanagement.ui;

import android.content.Context;

import com.android.homework.timemanagement.interactor.TodoInteractor;
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
    public ToastManager provideToastManager() {
        return new ToastManager(context);
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(ToastManager toastManager, TodoInteractor todoInteractor) {
        return new MainPresenter(toastManager, todoInteractor);
    }
}
