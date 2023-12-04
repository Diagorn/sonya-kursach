package com.example.demo.rest.dto.employee;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeDiscipline {
    private String name;
    private String departmentName;
    private List<String> groupNumbers;
    private String employeeFio;
}
