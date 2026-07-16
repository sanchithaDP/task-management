//package com.example.taskmanagementapi.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import tools.jackson.databind.ObjectMapper;
//
//import java.time.LocalDate;
//
//import static java.lang.reflect.Array.get;
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class TaskControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void testCreateTaskEndpoint() throws Exception {
//        TaskRequest request = new TaskRequest();
//        request.setTitle("Integration Test Task");
//        request.setDueDate(LocalDate.now().plusDays(5));
//
//        mockMvc.perform(post("/tasks")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("Integration Test Task"));
//    }
//    @Test
//    void testGetTaskNotFoundEndpoint() throws Exception {
//        mockMvc.perform(get("/tasks/invalid-id"))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.error").value("Not Found"));
//    }
//}
//
