package com.example.demo.rest.controller;

import com.example.demo.rest.dto.lesson.LessonDepartment;
import com.example.demo.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/schedule")
    public ResponseEntity<List<LessonDepartment>> getSchedule() {
        return lessonService.getSchedule();
    }

    @GetMapping("/schedule/{departmentId}")
    public ResponseEntity<LessonDepartment> getDepartmentSchedule(@PathVariable Long departmentId) {
        return lessonService.getSchedule(departmentId);
    }
}
