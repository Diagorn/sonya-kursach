package com.example.demo.rest.dto.employeeJob;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NewEmployeeJobRequest {
    private BigDecimal salary;
    private String position;
}
