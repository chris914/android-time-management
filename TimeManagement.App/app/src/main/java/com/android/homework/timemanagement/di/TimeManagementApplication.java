package com.android.homework.timemanagement.di;

import android.app.Application;

import com.android.homework.timemanagement.ui.UIModule;

public class TimeManagementApplication extends Application {
    public static TimeManagementApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerTimeManagementApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
