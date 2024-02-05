package com.example.casestudy.dto.requests;

import lombok.Data;

@Data
public class StudentCreateRequest {
        Long studentId;
        String name;
        int grade;

}
