package com.example.demo.repo;

import com.example.demo.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByDateStartAfterOrderByDateStartAsc(LocalDateTime dateFrom);
}
