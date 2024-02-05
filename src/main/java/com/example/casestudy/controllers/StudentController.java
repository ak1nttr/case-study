package com.example.casestudy.controllers;


import com.example.casestudy.dto.requests.StudentCreateRequest;
import com.example.casestudy.dto.requests.StudentUpdateRequest;
import com.example.casestudy.dto.response.StudentResponse;
import com.example.casestudy.entities.Course;
import com.example.casestudy.entities.Student;
import com.example.casestudy.repositories.StudentRepository;
import com.example.casestudy.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalLong;
import java.util.Set;

@Controller
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;



    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }


    //get all the students
    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }
    //get only one of them by id
    @GetMapping("/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId){
       return studentService.getStudentById(studentId);
    }

    //create a new student
    @PostMapping
    public Student saveNewStudent(@RequestBody StudentCreateRequest createRequest){
        return studentService.saveNewStudent(createRequest);
    }

    //update an existing student
    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody StudentUpdateRequest newStudent){
        return studentService.updateStudent(studentId,newStudent);
    }
    //delete an existing student
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }


}
