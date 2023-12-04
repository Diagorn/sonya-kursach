package com.example.demo.service.impl;

import com.example.demo.repo.LessonRepo;
import com.example.demo.rest.dto.lesson.LessonInfo;
import com.example.demo.service.LessonService;
import com.example.demo.utils.converters.lesson.LessonConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;

    private final LessonConverterFactory lessonConverterFactory;

    @Override
    public ResponseEntity<List<LessonInfo>> getSchedule() {
        List<LessonInfo> schedule = lessonRepo.findAllByDateStartAfterOrderByDateStartAsc(LocalDateTime.now()).stream()
                .map(lesson -> lessonConverterFactory.getLessonInfoConverter().convert(lesson))
                .collect(Collectors.toList());
        return ResponseEntity.ok(schedule);
    }
}
