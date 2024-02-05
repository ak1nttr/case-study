package com.example.casestudy.dto.response;


import com.example.casestudy.entities.Student;
import lombok.Data;

@Data
public class StudentResponse {


    String name;
    int grade;

    public StudentResponse(Student entity){

        this.grade= entity.getGrade();
        this.name= entity.getName();
    }


}
