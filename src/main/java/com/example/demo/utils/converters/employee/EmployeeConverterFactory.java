package com.example.demo.utils.converters.employee;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class EmployeeConverterFactory {
    private final EmployeeFullConverter employeeFullConverter;
    private final AddEmployeeRequestConverter addEmployeeRequestConverter;
    private final EditEmployeeConverter editEmployeeConverter;
}
