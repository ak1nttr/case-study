package com.example.casestudy.dto.requests;

import lombok.Data;

@Data
public class CourseCreateRequest {

    Long courseId;
    String name;
    int credit;


}
