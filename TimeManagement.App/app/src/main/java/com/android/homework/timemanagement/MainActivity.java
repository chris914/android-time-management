package com.android.homework.timemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.ui.ToastManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ToastManager toastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeManagementApplication.injector.inject(this);

        toastManager.MakeText(this, "Hello from injected ToastManager!");
    }
}
