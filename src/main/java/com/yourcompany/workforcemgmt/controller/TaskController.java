/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
package com.yourcompany.workforcemgmt.controller;

import com.yourcompany.workforcemgmt.dto.CreateTaskRequest;
import com.yourcompany.workforcemgmt.dto.TaskDto;
import com.yourcompany.workforcemgmt.model.Task;
import com.yourcompany.workforcemgmt.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService = new TaskService();

    @PostMapping
    public TaskDto create(@RequestBody CreateTaskRequest request) {
        return new TaskDto(taskService.createTask(
                request.title, request.assignedTo, request.startDate, request.dueDate
        ));
    }

    @GetMapping("/{id}")
    public TaskDto get(@PathVariable String id) {
        return new TaskDto(taskService.getTaskById(id));
    }

    @GetMapping("/range")
    public List<TaskDto> getByDateRange(@RequestParam String userId,
                                        @RequestParam String from,
                                        @RequestParam String to) {
        List<Task> tasks = taskService.getTasksForUserWithinDateRange(
                userId, LocalDate.parse(from), LocalDate.parse(to)
        );
        return tasks.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    @PostMapping("/{id}/priority")
    public void changePriority(@PathVariable String id, @RequestParam String priority) {
        taskService.changePriority(id, priority.toUpperCase());
    }

    @GetMapping("/priority/{priority}")
    public List<TaskDto> getByPriority(@PathVariable String priority) {
        return taskService.getTasksByPriority(priority.toUpperCase())
                .stream().map(TaskDto::new).collect(Collectors.toList());
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable String id, @RequestParam String comment) {
        taskService.addComment(id, comment);
    }

    @PostMapping("/{id}/reassign")
    public void reassignTask(@PathVariable String id, @RequestParam String newUserId) {
        taskService.reassignTask(id, newUserId);
    }
}
