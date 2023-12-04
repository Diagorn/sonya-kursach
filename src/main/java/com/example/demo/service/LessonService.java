package com.example.demo.service;

import com.example.demo.rest.dto.lesson.LessonInfo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LessonService {
    ResponseEntity<List<LessonInfo>> getSchedule();
}
