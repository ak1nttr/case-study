package com.example.casestudy.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@Table(name = "exams")
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    Long examId;

    String name;
    Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "course_course_id")
    Course course; //each exam will contain only one exam

    double duration;//will be considered as minutes

}
