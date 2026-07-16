package com.example.taskmanagementapi.repository;

import com.example.taskmanagementapi.domain.Task;

import java.util.*;

public class InMemoryTaskRepository implements TaskRepository {

    private final Map<String, Task> store = new HashMap<>();

    @Override
    public Task save(Task task) {
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Task> findAll() {
        return store.values().stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .toList();
    }

    @Override
    public void deleteById(String id) {
        store.remove(id);
    }
}
