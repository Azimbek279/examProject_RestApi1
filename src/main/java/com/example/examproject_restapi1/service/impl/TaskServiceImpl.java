package com.example.examproject_restapi1.service.impl;

import com.example.examproject_restapi1.DTO.task.TaskRequest;
import com.example.examproject_restapi1.DTO.task.TaskResponse;
import com.example.examproject_restapi1.converter.task.TaskRequestConverter;
import com.example.examproject_restapi1.converter.task.TaskResponseConverter;
import com.example.examproject_restapi1.entities.Lesson;
import com.example.examproject_restapi1.entities.Task;
import com.example.examproject_restapi1.repository.LessonRepository;
import com.example.examproject_restapi1.repository.TaskRepository;
import com.example.examproject_restapi1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;

    private final TaskRequestConverter taskRequestConverter;

    private final TaskResponseConverter taskResponseConverter;

    @Override
    public List<TaskResponse> getAllTasks(Long id) {
        return taskResponseConverter.view(taskRepository.getAllTasks(id));
    }

    @Override
    public TaskResponse addTask(Long id, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        Task task = taskRequestConverter.createTask(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskResponseConverter.viewTask(taskRepository.getById(id));
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        Task task = taskRepository.findById(id).get();
        taskRequestConverter.updateTask(task, taskRequest);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);
    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return taskResponseConverter.viewTask(task);
    }
}
