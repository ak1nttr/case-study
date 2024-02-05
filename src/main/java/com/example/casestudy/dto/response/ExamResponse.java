package com.example.casestudy.dto.response;

import com.example.casestudy.entities.Exam;
import lombok.Data;

import java.util.Date;

@Data
public class ExamResponse {
    String name;
     double duration;
     Date date;

     public ExamResponse(Exam entity){
         this.date =entity.getDate();
         this.duration= entity.getDuration();
         this.name= entity.getName();
     }


}
