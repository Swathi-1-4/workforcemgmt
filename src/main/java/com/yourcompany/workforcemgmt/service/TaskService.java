/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
package com.yourcompany.workforcemgmt.service;

import com.yourcompany.workforcemgmt.model.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    public Task createTask(String title, String assignedTo, LocalDate startDate, LocalDate dueDate) {
        Task task = new Task(title, assignedTo, startDate, dueDate);
        tasks.put(task.getId(), task);
        return task;
    }

    public Task getTaskById(String id) {
        return tasks.get(id);
    }

    public List<Task> getTasksForUserWithinDateRange(String userId, LocalDate from, LocalDate to) {
        return tasks.values().stream()
                .filter(t -> t.getAssignedTo().equals(userId))
                .filter(t -> !t.getStatus().equals("CANCELLED"))
                .filter(t
                        -> (t.getStartDate().compareTo(from) >= 0 && t.getStartDate().compareTo(to) <= 0)
                || (t.getStartDate().isBefore(from) && t.getStatus().equals("ACTIVE"))
                )
                .collect(Collectors.toList());
    }

    public void changePriority(String id, String priority) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setPriority(priority);
            task.addActivity("Priority changed to " + priority);
        }
    }

    public List<Task> getTasksByPriority(String priority) {
        return tasks.values().stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
    }

    public void addComment(String id, String comment) {
        Task task = getTaskById(id);
        if (task != null) {
            task.addComment(comment);
        }
    }

    public void reassignTask(String id, String newUserId) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setStatus("CANCELLED");
            task.addActivity("Reassigned, marked as CANCELLED");

            Task newTask = new Task(task.getTitle(), newUserId, LocalDate.now(), task.getDueDate());
            tasks.put(newTask.getId(), newTask);
        }
    }
}
