package com.yourcompany.workforcemgmt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private String id;
    private String title;
    private String assignedTo;
    private LocalDate startDate;
    private LocalDate dueDate;
    private String status; // ACTIVE, COMPLETED, CANCELLED
    private String priority; // HIGH, MEDIUM, LOW
    private List<String> comments;
    private List<String> activityHistory;

    public Task(String title, String assignedTo, LocalDate startDate, LocalDate dueDate) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.assignedTo = assignedTo;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = "ACTIVE";
        this.priority = "MEDIUM";
        this.comments = new ArrayList<>();
        this.activityHistory = new ArrayList<>();
        addActivity("Task created");
    }

    public void addActivity(String activity) {
        this.activityHistory.add(activity);
    }

    public void addComment(String comment) {
        this.comments.add(comment);
        addActivity("Comment added: " + comment);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<String> getActivityHistory() {
        return activityHistory;
    }

    public void setActivityHistory(List<String> activityHistory) {
        this.activityHistory = activityHistory;
    }
    

    
    
}