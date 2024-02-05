package com.example.casestudy.controllers;

import com.example.casestudy.dto.requests.ExamCreateRequest;
import com.example.casestudy.dto.requests.ExamUpdateRequest;
import com.example.casestudy.dto.response.ExamResponse;
import com.example.casestudy.entities.Exam;
import com.example.casestudy.services.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/exams")
public class ExamController {

    private final ExamService examService;
    public ExamController(ExamService examService){
        this.examService=examService;
    }


    //get all exams
    @GetMapping
    public List<ExamResponse> getAllExams(){
        return examService.getAllExams();
    }

    //get only one exam
    @GetMapping("/{examId}")
    public ExamResponse getExamById(@PathVariable Long examId){
        return examService.getExamById(examId);
    }

    //create a new one
    @PostMapping
    public Exam createNewExam(@RequestBody ExamCreateRequest createRequest){
        return examService.createNewExam(createRequest);
    }
    //update a present exam
    @PutMapping("/{examId}")
    public Exam updateExamById(@PathVariable Long examId, @RequestBody ExamUpdateRequest updateRequest){
        return examService.updateExamById(examId,updateRequest);
    }

    //delete an exam by id

}
