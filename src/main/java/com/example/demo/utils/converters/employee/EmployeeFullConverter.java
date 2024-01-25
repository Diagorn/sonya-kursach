package com.example.demo.utils.converters.employee;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.degree.DegreeResponse;
import com.example.demo.rest.dto.employee.EmployeeFull;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeFullConverter implements Converter<Employee, EmployeeFull> {
    @Override
    public EmployeeFull convert(Employee obj) {
        var departmentNames = obj.getDepartments() == null ? "" :
                obj.getDepartments().stream()
                        .map(Department::getName)
                        .collect(Collectors.joining(";"));

        return EmployeeFull.builder()
                .id(obj.getId())
                .fio(obj.getFio())
                .dateOfBirth(obj.getDateOfBirth())
                .isActive(obj.isActive())
                .passportSerie(obj.getPassportSerie())
                .passportNumber(obj.getPassportNumber())
                .passportGivingOrgan(obj.getPassportGiverOrgan())
                .passportDepCode(obj.getPassportDepCode())
                .registrationAddress(obj.getRegistrationAddress())
                .empRecordNum(obj.getEmpRecordNum())
                .isEmpRecordDigital(obj.isEmpRecordDigital())
                .empRecordDateStart(obj.getEmpRecordDateStart())
                .contractNumber(obj.getContractNumber())
                .contractDate(obj.getContractDate())
                .contractExpireDate(obj.getContractExpireDate())
                .rank(obj.getRank())
                .degree(obj.getDegree() == null ? null : DegreeResponse.builder()
                        .id(obj.getDegree().getId())
                        .name(obj.getDegree().getName())
                        .build())
                .departments(departmentNames)
                .build();
    }
}
