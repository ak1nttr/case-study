package com.example.casestudy.services;


import com.example.casestudy.dto.requests.ExamCreateRequest;
import com.example.casestudy.dto.requests.ExamUpdateRequest;
import com.example.casestudy.dto.response.ExamResponse;
import com.example.casestudy.entities.Course;
import com.example.casestudy.entities.Exam;
import com.example.casestudy.repositories.CourseRepository;
import com.example.casestudy.repositories.ExamRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamService {

    private ExamRepository examRepository;
    private CourseRepository courseRepository;
    public ExamService(ExamRepository examRepository , CourseRepository courseRepository){
        this.examRepository= examRepository;
        this.courseRepository=courseRepository;
    }

    public List<ExamResponse> getAllExams(){
        List<Exam> list = examRepository.findAll();
        return list.stream()
                .map(exam -> new ExamResponse(exam))
                .collect(Collectors.toList());
    }

    public ExamResponse getExamById(Long id){
        Optional<Exam> optional = examRepository.findById(id);
        if (optional.isPresent()){
            return new ExamResponse(optional.get());
        }
        else return null;
    }

    public Exam createNewExam(@RequestBody ExamCreateRequest createRequest){
        Optional<Course> optionalCourse= courseRepository.findById(createRequest.getCourseId());
        if (optionalCourse.isPresent()){
            Exam newExam = new Exam();
            newExam.setExamId(createRequest.getId());
            newExam.setDuration(createRequest.getDuration());
            newExam.setDate(createRequest.getDate());
            newExam.setName(createRequest.getName());
            newExam.setCourse(optionalCourse.get());
            return examRepository.save(newExam);
        }
        else return null;
    }

    public Exam updateExamById(Long id , @RequestBody ExamUpdateRequest updateRequest){
        Optional<Exam> optional = examRepository.findById(id);
        if (optional.isPresent()){
            Exam newExam = optional.get();
            newExam.setDate(updateRequest.getDate());
            newExam.setName(updateRequest.getName());
            newExam.setDuration(updateRequest.getDuration());
            return examRepository.save(newExam);

        }else return null;
    }

    public void deleteExamById(Long id){
        Optional<Exam> optional = examRepository.findById(id);
        if (optional.isPresent()) {
            examRepository.deleteById(id);
        }

    }



}
