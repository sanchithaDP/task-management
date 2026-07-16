package com.example.taskmanagementapi.controller;

import com.example.taskmanagementapi.domain.Task;
import com.example.taskmanagementapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/tasks")
    public class TaskController {
        private final TaskService service;

        public TaskController(TaskService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<Task> createTask(@RequestBody TaskRequest request) {
            Task task = service.createTask(request.title, request.description, String.valueOf(request.dueDate));
            return ResponseEntity.ok(task);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Task> getTask(@PathVariable String id) {
            return ResponseEntity.ok(service.getTask(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody TaskRequest request) {
            Task task = service.updateTask(id, request.title, request.description, request.status, request.dueDate);
            return ResponseEntity.ok(task);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable String id) {
            service.deleteTask(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping
        public ResponseEntity<List<Task>> listTasks() {
            return ResponseEntity.ok(service.listTasks());
        }
    }
