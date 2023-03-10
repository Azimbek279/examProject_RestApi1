package com.example.examproject_restapi1.service;


import com.example.examproject_restapi1.DTO.student.StudentRequest;
import com.example.examproject_restapi1.DTO.student.StudentResponse;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllListStudent();

    List<StudentResponse> getAllStudents(Long id);

    StudentResponse addStudent(Long id, StudentRequest student) throws IOException;

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest student, Long id) throws IOException;

    StudentResponse deleteStudent(Long id);

    void assignStudent(Long groupId, Long studentId) throws IOException;
}
