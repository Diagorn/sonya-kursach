package com.example.demo.utils.converters.department;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class DepartmentConverterFactory {
    private final DepartmentDtoConverter departmentDtoConverter;
}
