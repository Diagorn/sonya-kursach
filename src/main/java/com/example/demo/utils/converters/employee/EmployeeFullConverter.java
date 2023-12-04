package com.example.demo.utils.converters.employee;

import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.employee.EmployeeFull;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFullConverter implements Converter<Employee, EmployeeFull> {
    @Override
    public EmployeeFull convert(Employee obj) {
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
                .build();
    }
}
