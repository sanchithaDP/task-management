package com.example.taskmanagementapi.controller;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class TaskRequest {

    public String title;

    public String description;

    public String status; // Optional: must be one of PENDING, IN_PROGRESS, DONE

    public LocalDate dueDate;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotNull
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotNull LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}

