package com.android.homework.timemanagement.ui.main;

import com.android.homework.timemanagement.data.DatabaseManager;
import com.android.homework.timemanagement.data.QueryFavoritesEvent;
import com.android.homework.timemanagement.di.TimeManagementApplication;
import com.android.homework.timemanagement.interactor.TodoInteractor;
import com.android.homework.timemanagement.interactor.event.GetTodosEvent;
import com.android.homework.timemanagement.model.Task;
import com.android.homework.timemanagement.network.NetworkConfig;
import com.android.homework.timemanagement.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    TodoInteractor todoInteractor;

    List<Task> currentTasks;

    @Inject
    DatabaseManager databaseManager;

    @Inject
    public MainPresenter(TodoInteractor todoInteractor)
    {
        this.todoInteractor = todoInteractor;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        TimeManagementApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void addNewTodo()
    {
        Task t = new Task();
        t.setContent("Sample task");
        t.setProjectId(NetworkConfig.DEFAULT_PROJECT_ID);

        todoInteractor.addTask(t);
        // callback to screen, as this requires invoking a new activity.
        screen.addTodo();

    }

    public void openTodo(int todoId)
    {
        todoInteractor.getTask(todoId);

        // callback to screen, as this requires invoking a new activity.
        screen.openTodoScreen(todoId);
    }

    public void loadTodoList()
    {
        todoInteractor.getTasks();
    }

    public void addToFavorite(Long taskId)
    {
        // TODO: call back "better" than reloading the whole list.
        databaseManager.addToFavorites(taskId);
        this.loadTodoList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetTodosEvent event) {
        if (screen != null) {
            currentTasks = event.getTasks();
            databaseManager.getFavorites();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final QueryFavoritesEvent event) {
        if (screen != null) {
            screen.showTodos(currentTasks, event.getTasks());
        }
    }
}
