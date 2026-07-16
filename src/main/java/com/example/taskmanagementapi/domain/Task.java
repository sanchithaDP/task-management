package com.example.taskmanagementapi.domain;

import ch.qos.logback.core.status.Status;

import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private final String id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;

    public Task(String id) {
        this.id = id;
    }

    public enum Status { PENDING, IN_PROGRESS, DONE }

    public Task(String title, String description, LocalDate dueDate) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is required");
        if (dueDate == null || dueDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Due date must be in the future");
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
