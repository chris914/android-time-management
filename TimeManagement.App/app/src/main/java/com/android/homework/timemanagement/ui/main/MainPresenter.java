package com.android.homework.timemanagement.ui.main;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.ui.Presenter;
import com.android.homework.timemanagement.ui.ToastManager;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    ToastManager toastManager;

    @Inject
    public MainPresenter(ToastManager toastManager)
    {
        this.toastManager = toastManager;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        TimeManagementApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void makeToast(String text)
    {
        toastManager.makeText(text);
        screen.callbackAfterToastShown(text);
    }
}
