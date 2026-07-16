package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.domain.Task;
import com.example.taskmanagementapi.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService(new InMemoryTaskRepository());
    }

  // Since InMemoryTaskRepository is just a HashMap inside memory, you don’t need a database. You can directly instantiate it in your tests and verify behavior.
    @Test
    void testCreateTask() {
        Task task = service.createTask("Test Task", "Description", String.valueOf(LocalDate.now().plusDays(1)));
        assertNotNull(task.getId());
        assertEquals("Test Task", task.getTitle());
        assertEquals(Task.Status.PENDING, task.getStatus());
    }

    @Test
    void testGetTaskNotFound() {
        Exception ex = assertThrows(RuntimeException.class, () -> service.getTask("invalid-id"));
        assertTrue(ex.getMessage().contains("not found"));
    }

    @Test
    void testUpdateTask() {
        Task task = service.createTask("Original", "Desc", String.valueOf(LocalDate.now().plusDays(2)));
        Task updated = service.updateTask(task.getId(), "Updated", null, "IN_PROGRESS", null);
        assertEquals("Updated", updated.getTitle());
        assertEquals(Task.Status.IN_PROGRESS, updated.getStatus());
    }

    @Test
    void testDeleteTask() {
        Task task = service.createTask("Delete Me", "Desc", String.valueOf(LocalDate.now().plusDays(3)));
        service.deleteTask(task.getId());
        assertThrows(RuntimeException.class, () -> service.getTask(task.getId()));
    }
}


