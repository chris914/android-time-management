package com.android.homework.timemanagement.model;

import java.util.Objects;
import java.util.Date;

import com.google.gson.annotations.SerializedName;




public class Comment   {

    @SerializedName("content")
    private String content = null;

    @SerializedName("id")
    private Long id = null;

    @SerializedName("posted")
    private Date posted = null;

    @SerializedName("project_id")
    private Long projectId = null;

    @SerializedName("task_id")
    private Long taskId = null;

    @SerializedName("attachment")
    private CommentAttachment attachment = null;



    /**
     **/
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    /**
     **/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    /**
     **/
    public Date getPosted() {
        return posted;
    }
    public void setPosted(Date posted) {
        this.posted = posted;
    }


    /**
     **/
    public Long getProjectId() {
        return projectId;
    }
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    /**
     **/
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }


    /**
     **/
    public CommentAttachment getAttachment() {
        return attachment;
    }
    public void setAttachment(CommentAttachment attachment) {
        this.attachment = attachment;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return Objects.equals(content, comment.content) &&
                Objects.equals(id, comment.id) &&
                Objects.equals(posted, comment.posted) &&
                Objects.equals(projectId, comment.projectId) &&
                Objects.equals(taskId, comment.taskId) &&
                Objects.equals(attachment, comment.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, id, posted, projectId, taskId, attachment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Comment {\n");

        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    posted: ").append(toIndentedString(posted)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
        sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

class CommentAttachment   {

    @SerializedName("file_url")
    private String fileUrl = null;

    @SerializedName("file_name")
    private String fileName = null;

    @SerializedName("file_type")
    private String fileType = null;

    @SerializedName("resource_type")
    private String resourceType = null;



    /**
     **/
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


    /**
     **/
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    /**
     **/
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }


    /**
     **/
    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommentAttachment commentAttachment = (CommentAttachment) o;
        return Objects.equals(fileUrl, commentAttachment.fileUrl) &&
                Objects.equals(fileName, commentAttachment.fileName) &&
                Objects.equals(fileType, commentAttachment.fileType) &&
                Objects.equals(resourceType, commentAttachment.resourceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUrl, fileName, fileType, resourceType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentAttachment {\n");

        sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    fileType: ").append(toIndentedString(fileType)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}