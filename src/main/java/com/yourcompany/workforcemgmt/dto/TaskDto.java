/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
package com.yourcompany.workforcemgmt.dto;

import com.yourcompany.workforcemgmt.model.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskDto {

    public String id;
    public String title;
    public String assignedTo;
    public LocalDate startDate;
    public LocalDate dueDate;
    public String status;
    public String priority;
    public List<String> comments;
    public List<String> activityHistory;

    public TaskDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.assignedTo = task.getAssignedTo();
        this.startDate = task.getStartDate();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
        this.priority = task.getPriority();
        this.comments = task.getComments();
        this.activityHistory = task.getActivityHistory();
    }
}
