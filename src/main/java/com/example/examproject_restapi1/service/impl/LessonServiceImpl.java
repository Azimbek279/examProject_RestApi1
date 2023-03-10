package com.example.examproject_restapi1.service.impl;

import com.example.examproject_restapi1.DTO.lesson.LessonRequest;
import com.example.examproject_restapi1.DTO.lesson.LessonResponse;
import com.example.examproject_restapi1.converter.lesson.LessonRequestConverter;
import com.example.examproject_restapi1.converter.lesson.LessonResponseConverter;
import com.example.examproject_restapi1.entities.Course;
import com.example.examproject_restapi1.entities.Lesson;
import com.example.examproject_restapi1.repository.CourseRepository;
import com.example.examproject_restapi1.repository.LessonRepository;
import com.example.examproject_restapi1.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final LessonRequestConverter lessonRequestConverter;
    private final LessonResponseConverter lessonResponseConverter;

    @Override
    public List<LessonResponse> getAllLessons(Long id) {
        return lessonResponseConverter.view(lessonRepository.getAllLessons(id));
    }

    @Override
    public LessonResponse addLesson(Long id, LessonRequest lessonRequest) {
        Course course = courseRepository.getById(id);
        Lesson lesson = lessonRequestConverter.createLesson(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonResponseConverter.viewLesson(lessonRepository.getById(id));
    }

    @Override
    public LessonResponse updateLesson(LessonRequest lessonRequest, Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRequestConverter.updateLesson(lesson, lessonRequest);
        lessonRepository.save(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }

    @Override
    public LessonResponse deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.delete(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }
}
