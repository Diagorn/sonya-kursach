package com.example.demo.rest.dto.employee;

import com.example.demo.rest.dto.degree.DegreeResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeFull {
    private Long id;
    private String fio;
    private LocalDate dateOfBirth;
    private boolean isActive;
    private String passportSerie;
    private String passportNumber;
    private String passportGivingOrgan;
    private String passportDepCode;
    private String registrationAddress;
    private String empRecordNum;
    private boolean isEmpRecordDigital;
    private LocalDate empRecordDateStart;
    private String contractNumber;
    private LocalDate contractDate;
    private LocalDate contractExpireDate;
    private String rank;
    private DegreeResponse degree;
}
