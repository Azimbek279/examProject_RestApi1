package com.example.examproject_restapi1.service;


import com.example.examproject_restapi1.DTO.task.TaskRequest;
import com.example.examproject_restapi1.DTO.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks(Long id);

    TaskResponse addTask(Long id, TaskRequest taskRequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}
