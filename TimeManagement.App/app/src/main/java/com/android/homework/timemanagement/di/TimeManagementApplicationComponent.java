package com.android.homework.timemanagement.di;

import com.android.homework.timemanagement.interactor.InteractorModule;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.ui.calendar.CalendarActivity;
import com.android.homework.timemanagement.ui.calendar.CalendarPresenter;
import com.android.homework.timemanagement.ui.details.TodoDetailsActivity;
import com.android.homework.timemanagement.ui.details.TodoDetailsPresenter;
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

    void inject(TodoDetailsActivity detailsActivity);
    void inject(TodoDetailsPresenter detailsPresenter);

    void inject(CalendarActivity calendarActivity);
    void inject(CalendarPresenter calendarPresenter);
}
