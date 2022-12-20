package com.example.examproject_restapi1.converter.student;

import com.example.examproject_restapi1.DTO.student.StudentResponse;
import com.example.examproject_restapi1.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseConverter {
    public StudentResponse viewStudent(Student student){
        if (student==null){
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setPhoneNumber(student.getPhoneNumber());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setStudyFormat(student.getStudyFormat());

        return studentResponse;
    }


    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> studentResponses = new ArrayList<>();

        for (Student student: students) {
            studentResponses.add(viewStudent(student));
        }

        return  studentResponses;
    }
}
