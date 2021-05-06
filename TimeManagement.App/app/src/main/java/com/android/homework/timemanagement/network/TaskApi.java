package com.android.homework.timemanagement.network;

import com.android.homework.timemanagement.model.Task;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface TaskApi {

    /**
     * Get active tasks for a given project
     * Returns a JSON-encoded array containing all active tasks for a specified project.
     * @param projectId ID of the project
     * @return Call<List<Task>>
     */

    @GET("tasks")
    Call<List<Task>> getTasks(
            @Header("Authorization") String auth,
            @Query("project_id") Long projectId
    );


    /**
     * Add a new task
     *
     * @param body Task object to be added to the active tasks
     * @return Call<Void>
     */

    @POST("tasks")
    Call<Void> addTask(
            @Header("Authorization") String auth,
            @Body Task body
    );


    /**
     * Get active task by id
     * Returns a single active (non-completed) task by ID as a JSON object.
     * @param id ID of the task
     * @return Call<List<Task>>
     */

    @GET("tasks/{Id}")
    Call<Task> getTaskById(
            @Header("Authorization") String auth,
            @Path("Id") Long id
    );


    /**
     * Update an existing Task
     *
     * @param id ID of the task
     * @param body
     * @return Call<Void>
     */

    @PUT("tasks/{Id}")
    Call<Void> updateTask(
            @Header("Authorization") String auth,
            @Path("Id") Long id, @Body Task body
    );


    /**
     * Deletes a Task
     *
     * @param id Task id to delete
     * @return Call<Void>
     */

    @DELETE("tasks/{Id}")
    Call<Void> deleteTask(
            @Header("Authorization") String auth,
            @Path("Id") Long id
    );


    /**
     * Closes a task
     * Closes an active task.
     * @param id ID of the task
     * @return Call<Void>
     */

    @POST("tasks/{Id}/close")
    Call<Void> closeTask(
            @Header("Authorization") String auth,
            @Path("Id") Long id
    );


}

