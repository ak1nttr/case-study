package com.example.casestudy.dto.requests;


import lombok.Data;

import java.util.Date;

@Data
public class ExamCreateRequest {
    Long id;
    String name;
    double duration;
    Long courseId;
    Date date;




}
