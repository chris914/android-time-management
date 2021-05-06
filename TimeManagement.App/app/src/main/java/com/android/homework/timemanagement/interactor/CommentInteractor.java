package com.android.homework.timemanagement.interactor;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.event.GetTodosEvent;
import com.android.homework.timemanagement.model.Comment;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.network.CommentApi;
import com.android.homework.timemanagement.network.NetworkConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentInteractor {
    public CommentInteractor() {
        TimeManagementApplication.injector.inject(this);
    }

    @Inject
    CommentApi commentApi;

    public void getComments(long taskId)
    {
        Call<List<Comment>> call = commentApi.getCommentsForTask(NetworkConfig.AUTH, taskId);
        try {
            call.enqueue(new Callback<List<Comment>>() {
                @Override
                public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                }

                @Override
                public void onFailure(Call<List<Comment>> call, Throwable t) {

                }
            });
        }
        catch (Exception e) {
        }
    }

    public void addComment(Comment comment)
    {
        Call<Comment> call = commentApi.addComment(NetworkConfig.AUTH, comment);
        try{
            call.enqueue(new Callback<Comment>() {
                @Override
                public void onResponse(Call<Comment> call, Response<Comment> response) {

                }

                @Override
                public void onFailure(Call<Comment> call, Throwable t) {

                }
            });
        }
        catch (Exception e) {

        }
    }
}
