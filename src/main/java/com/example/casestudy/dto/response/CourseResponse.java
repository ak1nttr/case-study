package com.example.casestudy.dto.response;

import com.example.casestudy.entities.Course;
import lombok.Data;

@Data
public class CourseResponse {
    String name;
    int credit;

        public CourseResponse(Course entity){
            this.name = entity.getName();
            this.credit= entity.getCredit();
        }

}
