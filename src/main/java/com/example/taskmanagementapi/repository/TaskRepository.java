package com.example.taskmanagementapi.repository;

import com.example.taskmanagementapi.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository {
        Task save(Task task);
        Optional<Task> findById(String id);
        List<Task> findAll();
        void deleteById(String id);
    }

