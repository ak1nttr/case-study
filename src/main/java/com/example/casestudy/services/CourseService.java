package com.example.casestudy.services;


import com.example.casestudy.dto.requests.CourseCreateRequest;
import com.example.casestudy.dto.requests.CourseUpdateRequest;
import com.example.casestudy.dto.response.CourseResponse;
import com.example.casestudy.entities.Course;
import com.example.casestudy.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }


    public Course createNewCourse(@RequestBody CourseCreateRequest createRequest){
        Course newCourse = new Course();
        newCourse.setCourseId(createRequest.getCourseId());
        newCourse.setCredit(createRequest.getCredit());
        newCourse.setName(createRequest.getName());
        return courseRepository.save(newCourse);
    }

    public List<CourseResponse> getAllCourses(){
       List<Course> list = courseRepository.findAll();
       return list.stream()
               .map(course -> new CourseResponse(course))
               .collect(Collectors.toList());
    }

    public Course getCourseById(Long id){
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }else return null;
    }

    public Course updateCourseById(Long id,@RequestBody CourseUpdateRequest updateRequest){
        Optional<Course> optional = courseRepository.findById(id);
        if (optional.isPresent()){
            Course newCourse = optional.get();
            newCourse.setCredit(updateRequest.getCredit());
            newCourse.setName(updateRequest.getName());
            return courseRepository.save(newCourse);
        }else return null;
    }


    public void deleteCourseById(Long id){
        courseRepository.deleteById(id);
    }

}
