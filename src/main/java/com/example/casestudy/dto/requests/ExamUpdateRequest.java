package com.example.casestudy.dto.requests;


import lombok.Data;

import java.util.Date;

@Data
public class ExamUpdateRequest {

    String name;
    Date date;
    double duration;
}
