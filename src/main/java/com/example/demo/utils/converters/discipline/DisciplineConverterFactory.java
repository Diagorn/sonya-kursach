package com.example.demo.utils.converters.discipline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class DisciplineConverterFactory {
    private final DisciplineDtoConverter disciplineDtoConverter;
}
