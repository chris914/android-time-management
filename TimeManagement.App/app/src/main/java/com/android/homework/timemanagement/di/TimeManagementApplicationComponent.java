package com.android.homework.timemanagement.di;

import com.android.homework.timemanagement.interactor.InteractorModule;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.ui.main.MainActivity;
import com.android.homework.timemanagement.ui.ToastManager;
import com.android.homework.timemanagement.ui.UIModule;
import com.android.homework.timemanagement.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})
public interface TimeManagementApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(ToastManager toastManager);
    void inject(TodoInteractor todoInteractor);
}
