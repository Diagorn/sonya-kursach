package com.example.demo.utils.converters.employee;

import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.employee.AddEmployeeRequest;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddEmployeeRequestConverter implements Converter<AddEmployeeRequest, Employee> {
    @Override
    public Employee convert(AddEmployeeRequest obj) {
        return Employee.builder()
                .fio(obj.getFio())
                .dateOfBirth(obj.getDateOfBirth())
                .isActive(obj.isActive())
                .passportSerie(obj.getPassportSerie())
                .passportNumber(obj.getPassportNumber())
                .passportGiverOrgan(obj.getPassportGivingOrgan())
                .passportDepCode(obj.getPassportDepCode())
                .registrationAddress(obj.getRegistrationAddress())
                .empRecordNum(obj.getEmpRecordNum())
                .isEmpRecordDigital(obj.isEmpRecordDigital())
                .empRecordDateStart(obj.getEmpRecordDateStart())
                .contractNumber(obj.getContractNumber())
                .contractDate(obj.getContractDate())
                .contractExpireDate(obj.getContractExpireDate())
                .rank(obj.getRank())
                .build();
    }
}
