package com.example.casestudy.services;

import com.example.casestudy.dto.requests.StudentCreateRequest;
import com.example.casestudy.dto.requests.StudentUpdateRequest;
import com.example.casestudy.dto.response.StudentResponse;
import com.example.casestudy.entities.Student;
import com.example.casestudy.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    //add student
    public Student saveNewStudent(@RequestBody StudentCreateRequest newStudent){


            Student studentToSave = new Student();
            studentToSave.setGrade(newStudent.getGrade());
            studentToSave.setStudentId(newStudent.getStudentId());
            studentToSave.setName(newStudent.getName());
            return studentRepository.save(studentToSave);

        }

    //delete student
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
    //update student
    public Student updateStudent(Long id , StudentUpdateRequest student){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student newStudent = optionalStudent.get();
            newStudent.setGrade(student.getGrade());
            return studentRepository.save(newStudent);
         }
        else return null;
    }
    //get one student by id
    public StudentResponse getStudentById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
            return new StudentResponse(optionalStudent.get());
        else return new StudentResponse(null);
    }
    //get all the students
    public List<StudentResponse> getAllStudents(){
        List<Student> list = studentRepository.findAll();
        return list.stream()
                .map(student -> new StudentResponse(student))
                .collect(Collectors.toList());

    }

}
