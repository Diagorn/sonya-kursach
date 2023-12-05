package com.example.demo.utils.converters.employeeJob;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class EmployeeJobConverterFactory {
    private final NewEmployeeJobConverter newEmployeeJobConverter;
    private final EmployeeJobFullConverter employeeJobFullConverter;
}
