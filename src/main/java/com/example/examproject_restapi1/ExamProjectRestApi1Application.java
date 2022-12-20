package com.example.examproject_restapi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ExamProjectRestApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamProjectRestApi1Application.class, args);

        System.out.println(LocalDate.now());
    }
}
