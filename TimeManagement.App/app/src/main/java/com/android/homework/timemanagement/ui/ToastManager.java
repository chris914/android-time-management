package com.android.homework.timemanagement.ui;

import android.content.Context;
import android.widget.Toast;

import com.android.homework.timemanagement.di.TimeManagementApplication;

// ToastManager class to test the Dagger DI framework.
public class ToastManager {

    Context context;

    public ToastManager(Context context)
    {
        this.context = context;
        TimeManagementApplication.injector.inject(this);
    }

    public void makeText(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
