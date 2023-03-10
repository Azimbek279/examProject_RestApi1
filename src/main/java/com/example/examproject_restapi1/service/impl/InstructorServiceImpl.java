package com.example.examproject_restapi1.service.impl;

import com.example.examproject_restapi1.DTO.instructor.InstructorRequest;
import com.example.examproject_restapi1.DTO.instructor.InstructorResponse;
import com.example.examproject_restapi1.converter.instructor.InstructorRequestConverter;
import com.example.examproject_restapi1.converter.instructor.InstructorResponseConverter;
import com.example.examproject_restapi1.entities.Course;
import com.example.examproject_restapi1.entities.Group;
import com.example.examproject_restapi1.entities.Instructor;
import com.example.examproject_restapi1.entities.Student;
import com.example.examproject_restapi1.repository.CourseRepository;
import com.example.examproject_restapi1.repository.InstructorRepository;
import com.example.examproject_restapi1.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final InstructorRequestConverter instructorRequestConverter;
    private final InstructorResponseConverter instructorResponseConverter;

    @Override
    public List<InstructorResponse> getAllList() {
        return instructorResponseConverter.view(instructorRepository.findAll());
    }

    @Override
    public List<InstructorResponse> getAllInstructor(Long courseId) {
        return instructorResponseConverter.view(instructorRepository.getAllInstructor(courseId));
    }

    @Override
    public InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest) throws IOException {
        Instructor instructor = instructorRequestConverter.createInstructor(instructorRequest);
        Course course = courseRepository.getById(id);
        if (course.getGroups()!=null){
            for (Group group : course.getGroups()) {
                for (Student student: group.getStudents()) {
                    instructor.plus();
                }
            }
        }
//        validator(instructorRequest.getPhoneNumber().replace(" ", ""), instructorRequest.getLastName().replace(" ", ""), instructorRequest.getFirstName().replace(" ", ""));
        course.addInstructors(instructor);
        instructor.setCourse(course);
        instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        Instructor instructor = instructorRepository.getById(id);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(InstructorRequest instructorRequest, Long id) throws IOException {
//        validator(instructorRequest.getPhoneNumber().replace(" ", ""), instructorRequest.getLastName().replace(" ", ""), instructorRequest.getFirstName().replace(" ", ""));
        Instructor instructor = instructorRepository.getById(id);
        instructorRequestConverter.updateInstructor(instructor, instructorRequest);
        instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id).get();
        instructorRepository.delete(instructor);
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public void assignInstructor(Long courseId, Long instructorId) throws IOException {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        Course course = courseRepository.findById(courseId).get();
        if (course.getInstructors()!=null){
            for (Instructor g : course.getInstructors()) {
                if (g.getId() == instructorId) {
                    throw new IOException("This instructor already exists!");
                }
            }
        }
        for (Group g:instructor.getCourse().getGroups()) {
            for (Student s:g.getStudents()) {
                instructor.minus();
            }
        }
        for (Group g: course.getGroups()) {
            for (Student s:g.getStudents()) {
                instructor.plus();
            }
        }
        instructor.getCourse().getInstructors().remove(instructor);
        instructor.setCourse(course);
        course.addInstructors(instructor);
        instructorRepository.save(instructor);
        courseRepository.save(course);
    }

//    private void validator(String phone, String firstName, String lastName) throws IOException {
//        if (firstName.length()>2 && lastName.length()>2) {
//            for (Character i : firstName.toCharArray()) {
//                if (!Character.isAlphabetic(i)) {
//                    throw new IOException("?? ?????????? ?????????????????????? ???????????? ?????????????????? ??????????");
//                }
//            }
//
//            for (Character i : lastName.toCharArray()) {
//                if (!Character.isAlphabetic(i)) {
//                    throw new IOException("?? ?????????????? ?????????????????????? ???????????? ?????????????????? ??????????");
//                }
//            }
//        } else {
//            throw new IOException("?? ?????????? ?????? ?????????????? ?????????????????????? ???????????? ???????? ?????? ?????????????? 3 ??????????");
//        }
//
//        if (phone.length()==13
//                && phone.charAt(0) == '+'
//                && phone.charAt(1) == '9'
//                && phone.charAt(2) == '9'
//                && phone.charAt(3) == '6'){
//            int counter = 0;
//
//            for (Character i : phone.toCharArray()) {
//                if (counter!=0){
//                    if (!Character.isDigit(i)) {
//                        throw new IOException("???????????? ???????????? ???? ????????????????????");
//                    }
//                }
//                counter++;
//            }
//        }else {
//            throw new IOException("???????????? ???????????? ???? ????????????????????");
//        }
//    }
}
