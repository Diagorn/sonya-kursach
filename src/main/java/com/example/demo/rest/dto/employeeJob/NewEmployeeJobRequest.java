package com.example.demo.rest.dto.employeeJob;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewEmployeeJobRequest {
    private BigDecimal salary;
    private String position;
}
