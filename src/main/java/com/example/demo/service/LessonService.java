package com.example.demo.service;

import com.example.demo.rest.dto.lesson.AddLessonRequest;
import com.example.demo.rest.dto.lesson.LessonDepartment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LessonService {
    ResponseEntity<List<LessonDepartment>> getSchedule();

    ResponseEntity<LessonDepartment> getSchedule(Long departmentId);

    LessonDepartment addLesson(AddLessonRequest request);

    void delete(Long id);
}
