package com.example.demo.rest.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeDisciplineRequest {
    private Long employeeId;
    private Long disciplineId;
}
