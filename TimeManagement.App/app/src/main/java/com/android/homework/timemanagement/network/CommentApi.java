package com.android.homework.timemanagement.network;


import com.android.homework.timemanagement.model.Comment;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface CommentApi {

    /**
     * Gets all comments for a specified task.
     * Gets a JSON-encoded array of all comments for a given task id
     * @param taskId ID of the task
     * @return Call<List<Comment>>
     */

    @GET("comments")
    Call<List<Comment>> getCommentsForTask(
            @Header("Authorization") String auth,
            @Query("task_id") Long taskId
    );


    /**
     * Add a new comment
     *
     * @param body Comment object to be attached to a task
     * @return Call<Comment>
     */

    @POST("comments")
    Call<Comment> addComment(
            @Header("Authorization") String auth,
            @Body Comment body
    );


    /**
     * Updates a comment.
     *
     * @param commentId ID of the comment
     * @param body
     * @return Call<Void>
     */

    @PUT("comments/{commentId}")
    Call<Void> updateComment(
            @Header("Authorization") String auth,
            @Path("commentId") Long commentId, @Body Body body
    );


    /**
     * Deletes a Comment
     *
     * @param commentId ID of the comment
     * @return Call<Void>
     */

    @DELETE("comments/{commentId}")
    Call<Void> deleteComment(
            @Header("Authorization") String auth,
            @Path("commentId") Long commentId
    );
}
