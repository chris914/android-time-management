package com.android.homework.timemanagement.model;

import java.util.Date;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




public class Task   {

    @SerializedName("assignee")
    private Integer assignee = null;

    @SerializedName("assigner")
    private Integer assigner = null;

    @SerializedName("comment_count")
    private Integer commentCount = null;

    @SerializedName("completed")
    private Boolean completed = null;

    @SerializedName("content")
    private String content = null;

    @SerializedName("due")
    private TaskDue due = null;

    @SerializedName("id")
    private Long id = null;

    @SerializedName("label_ids")
    private List<Long> labelIds = new ArrayList<Long>();

    @SerializedName("order")
    private Integer order = null;

    @SerializedName("priority")
    private Integer priority = null;

    @SerializedName("project_id")
    private Long projectId = null;

    @SerializedName("section_id")
    private Integer sectionId = null;

    @SerializedName("parent_id")
    private Long parentId = null;

    @SerializedName("url")
    private String url = null;



    /**
     **/
    public Integer getAssignee() {
        return assignee;
    }
    public void setAssignee(Integer assignee) {
        this.assignee = assignee;
    }


    /**
     **/
    public Integer getAssigner() {
        return assigner;
    }
    public void setAssigner(Integer assigner) {
        this.assigner = assigner;
    }


    /**
     **/
    public Integer getCommentCount() {
        return commentCount;
    }
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }


    /**
     **/
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


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
    public TaskDue getDue() {
        return due;
    }
    public void setDue(TaskDue due) {
        this.due = due;
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
    public List<Long> getLabelIds() {
        return labelIds;
    }
    public void setLabelIds(List<Long> labelIds) {
        this.labelIds = labelIds;
    }


    /**
     **/
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }


    /**
     **/
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
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
    public Integer getSectionId() {
        return sectionId;
    }
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }


    /**
     **/
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    /**
     **/
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(assignee, task.assignee) &&
                Objects.equals(assigner, task.assigner) &&
                Objects.equals(commentCount, task.commentCount) &&
                Objects.equals(completed, task.completed) &&
                Objects.equals(content, task.content) &&
                Objects.equals(due, task.due) &&
                Objects.equals(id, task.id) &&
                Objects.equals(labelIds, task.labelIds) &&
                Objects.equals(order, task.order) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(projectId, task.projectId) &&
                Objects.equals(sectionId, task.sectionId) &&
                Objects.equals(parentId, task.parentId) &&
                Objects.equals(url, task.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignee, assigner, commentCount, completed, content, due, id, labelIds, order, priority, projectId, sectionId, parentId, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Task {\n");

        sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
        sb.append("    assigner: ").append(toIndentedString(assigner)).append("\n");
        sb.append("    commentCount: ").append(toIndentedString(commentCount)).append("\n");
        sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    due: ").append(toIndentedString(due)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    labelIds: ").append(toIndentedString(labelIds)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    sectionId: ").append(toIndentedString(sectionId)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

class TaskDue {

    @SerializedName("date")
    private Date date = null;

    @SerializedName("datetime")
    private Date datetime = null;

    @SerializedName("string")
    private String string = null;

    @SerializedName("recurring")
    private Boolean recurring = null;

    @SerializedName("timezone")
    private String timezone = null;



    /**
     **/
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     **/
    public Date getDatetime() {
        return datetime;
    }
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }


    /**
     **/
    public String getString() {
        return string;
    }
    public void setString(String string) {
        this.string = string;
    }


    /**
     **/
    public Boolean getRecurring() {
        return recurring;
    }
    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }


    /**
     **/
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDue taskDue = (TaskDue) o;
        return Objects.equals(date, taskDue.date) &&
                Objects.equals(datetime, taskDue.datetime) &&
                Objects.equals(string, taskDue.string) &&
                Objects.equals(recurring, taskDue.recurring) &&
                Objects.equals(timezone, taskDue.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, datetime, string, recurring, timezone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TaskDue {\n");

        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
        sb.append("    string: ").append(toIndentedString(string)).append("\n");
        sb.append("    recurring: ").append(toIndentedString(recurring)).append("\n");
        sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
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
