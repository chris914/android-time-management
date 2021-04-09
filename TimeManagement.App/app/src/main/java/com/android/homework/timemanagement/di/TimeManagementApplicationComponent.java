package com.android.homework.timemanagement.di;

import com.android.homework.timemanagement.MainActivity;
import com.android.homework.timemanagement.ui.ToastManager;
import com.android.homework.timemanagement.ui.UIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class})
public interface TimeManagementApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(ToastManager toastManager);
}
