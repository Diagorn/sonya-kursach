package com.example.demo.rest.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddEmployeeRequest {
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
    private long categoryId;
}
