package com.example.examproject_restapi1.DTO.student;

import com.example.examproject_restapi1.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private StudyFormat studyFormat;
}
