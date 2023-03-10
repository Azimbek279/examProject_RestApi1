package com.example.examproject_restapi1.service;

import com.example.examproject_restapi1.DTO.instructor.InstructorRequest;
import com.example.examproject_restapi1.DTO.instructor.InstructorResponse;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getAllList();

    List<InstructorResponse> getAllInstructor(Long courseId);

    InstructorResponse addInstructor(Long id, InstructorRequest instructor) throws IOException;

    InstructorResponse getInstructorById(Long id);

    InstructorResponse updateInstructor(InstructorRequest instructor, Long id) throws IOException;

    InstructorResponse deleteInstructor(Long id);

    void assignInstructor(Long courseId, Long instructorId) throws IOException;
}
