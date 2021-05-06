package com.android.homework.timemanagement.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public TodoInteractor provideTodoInteractor() {
        return new TodoInteractor();
    }

    @Provides
    public CommentInteractor provideCommentInteractor() {
        return new CommentInteractor();
    }
}
