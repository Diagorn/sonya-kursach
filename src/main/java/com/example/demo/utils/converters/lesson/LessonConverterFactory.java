package com.example.demo.utils.converters.lesson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class LessonConverterFactory {
    private final LessonInfoConverter lessonInfoConverter;
}
