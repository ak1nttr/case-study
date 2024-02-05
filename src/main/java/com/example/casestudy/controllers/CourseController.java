package com.example.casestudy.controllers;

import com.example.casestudy.dto.requests.CourseCreateRequest;
import com.example.casestudy.dto.requests.CourseUpdateRequest;
import com.example.casestudy.dto.response.CourseResponse;
import com.example.casestudy.entities.Course;
import com.example.casestudy.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    //get all
    @GetMapping
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }
    //create a new one
    @PostMapping
    public Course createNewCourse(@RequestBody CourseCreateRequest courseCreateRequest){
        return courseService.createNewCourse(courseCreateRequest);
    }
    //get one of them by id

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return courseService.getCourseById(courseId);
    }

    @PutMapping("/{courseId}")
    public Course updateCourseById(@PathVariable Long courseId, @RequestBody CourseUpdateRequest updateRequest){
        return courseService.updateCourseById(courseId,updateRequest);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourseById(@PathVariable Long courseId){
        courseService.deleteCourseById(courseId);

    }


}
