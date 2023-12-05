package com.example.demo.rest.dto.employeeJob;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeeJobFull {
    private Long id;
    private String position;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String organizationName;
    private BigDecimal salary;
    private String employeeFio;
}
