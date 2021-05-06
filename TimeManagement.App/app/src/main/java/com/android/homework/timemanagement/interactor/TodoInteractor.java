package com.android.homework.timemanagement.interactor;

import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.event.AddTodoEvent;
import com.android.homework.timemanagement.interactor.event.CloseTodoEvent;
import com.android.homework.timemanagement.interactor.event.DeleteTodoEvent;
import com.android.homework.timemanagement.interactor.event.GetTodoEvent;
import com.android.homework.timemanagement.interactor.event.GetTodosEvent;
import com.android.homework.timemanagement.interactor.event.UpdateTodoEvent;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.network.NetworkConfig;
import com.android.homework.timemanagement.network.TaskApi;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoInteractor {

    public TodoInteractor() {
        TimeManagementApplication.injector.inject(this);
    }
    private List<Task> tasks;

    @Inject
    TaskApi taskApi;

    public void getTasks()
    {
        Call<List<Task>> call = taskApi.getTasks(NetworkConfig.AUTH, NetworkConfig.DEFAULT_PROJECT_ID);
        try {
            call.enqueue(new Callback<List<Task>>() {
                @Override
                public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                    GetTodosEvent event = new GetTodosEvent();
                    event.setTasks(response.body());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<List<Task>> call, Throwable t) {
                }
            });
        }
        catch (Exception e) {
        }
    }

    public void getTasks(Date startDate, Date endDate)
    {
        // Get tasks which are in between the two dates
        // send the result via eventbus
    }

    public void getTask(long taskId)
    {
        Call<Task> call = taskApi.getTaskById(NetworkConfig.AUTH, taskId);
        try {
            call.enqueue(new Callback<Task>() {
                @Override
                public void onResponse(Call<Task> call, Response<Task> response) {
                    GetTodoEvent event = new GetTodoEvent();
                    event.setTask(response.body());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Task> call, Throwable t) {

                }
            });
        }
        catch (Exception e) {
        }
    }

    public void addTask(Task task)
    {
        Call<Void> call = taskApi.addTask(NetworkConfig.AUTH, task);
        try {
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    AddTodoEvent event = new AddTodoEvent();
                    event.setCode(response.code());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        catch (Exception e)
        {

        }
    }

    public void closeTask(long taskId)
    {
        Call<Void> call = taskApi.closeTask(NetworkConfig.AUTH, taskId);
        try {
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    CloseTodoEvent event = new CloseTodoEvent();
                    event.setCode(response.code());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        catch (Exception e)
        {

        }
    }

    public void updateTask(long taskId, Task task)
    {
        Call<Void> call = taskApi.updateTask(NetworkConfig.AUTH, taskId, task);
        try {
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    UpdateTodoEvent event = new UpdateTodoEvent();
                    event.setCode(response.code());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        catch (Exception e) {
        }
    }

    public void deleteTask(long taskId)
    {
        Call<Void> call = taskApi.deleteTask(NetworkConfig.AUTH, taskId);
        try {
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    DeleteTodoEvent event = new DeleteTodoEvent();
                    event.setCode(response.code());
                    EventBus.getDefault().post(event);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        catch (Exception e) {
        }
    }
}
