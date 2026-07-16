package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.domain.Task;
import com.example.taskmanagementapi.exception.TaskNotFoundException;
import com.example.taskmanagementapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String title, String description, String dueDate) {
        Task task = new Task(title, description, java.time.LocalDate.parse(dueDate));
        return repository.save(task);
    }

    public Task getTask(String id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(String id, String title, String description, String status, LocalDate dueDate) {
        Task task = getTask(id);
        if (title != null) task.setTitle(title);
        if (description != null) task.setDescription(description);
        if (status != null) task.setStatus(Task.Status.valueOf(status));
        if (dueDate != null) task.setDueDate(dueDate);
        return repository.save(task);
    }

    public void deleteTask(String id) {
        if (repository.findById(id).isEmpty()) throw new TaskNotFoundException(id);
        repository.deleteById(id);
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }

//add pagination and filtering by status to your GET /tasks endpoint so you can grab those bonus points
//    public List<Task> listTasks(int page, int size, String status) {
//        List<Task> tasks = repository.findAll();
//
//        // Filter by status if provided
//        if (status != null && !status.isBlank()) {
//            tasks = tasks.stream()
//                    .filter(t -> t.getStatus().name().equalsIgnoreCase(status))
//                    .toList();
//        }
//
//        // Pagination
//        int fromIndex = page * size;
//        int toIndex = Math.min(fromIndex + size, tasks.size());
//        if (fromIndex > tasks.size()) return List.of();
//
//        return tasks.subList(fromIndex, toIndex);
//    }

}
