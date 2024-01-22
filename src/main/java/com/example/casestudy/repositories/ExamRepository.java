package com.example.casestudy.repositories;

import com.example.casestudy.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepositories extends JpaRepository<Exam,Long> {
}
