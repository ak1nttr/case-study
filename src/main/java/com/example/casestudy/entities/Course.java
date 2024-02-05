package com.example.casestudy.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "courses")
@NoArgsConstructor
public class Course {

    @Id
    private Long courseId;


    String name;

    int credit;



}
