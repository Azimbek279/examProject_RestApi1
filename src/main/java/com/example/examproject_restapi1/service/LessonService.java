package com.example.examproject_restapi1.service;

import com.example.examproject_restapi1.DTO.lesson.LessonRequest;
import com.example.examproject_restapi1.DTO.lesson.LessonResponse;

import java.util.List;

public interface LessonService {
    List<LessonResponse> getAllLessons(Long id);

    LessonResponse addLesson(Long id, LessonRequest lessonRequest);

    LessonResponse getLessonById(Long id);

    LessonResponse updateLesson(LessonRequest lessonRequest, Long id);

    LessonResponse deleteLesson(Long id);
}
