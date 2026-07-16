package com.example.taskmanagementapi.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String id) {
        super("Task with id '" + id + "' not found");
    }
}
