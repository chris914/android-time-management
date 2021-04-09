package com.android.homework.timemanagement.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.ui.ToastManager;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimeManagementApplication.injector.inject(this);

        findViewById(R.id.tvHelloWorld).setOnClickListener(v -> {
            mainPresenter.makeToast("Hello from Dagger MVP");
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void callbackAfterToastShown(String text) {
        // do something with 'text'...
    }
}
