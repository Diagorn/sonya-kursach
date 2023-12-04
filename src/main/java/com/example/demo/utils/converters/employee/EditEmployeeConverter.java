package com.example.demo.utils.converters.employee;

import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.employee.EditEmployeeRequest;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditEmployeeConverter implements Converter<EditEmployeeRequest, Employee> {
    @Override
    public Employee convert(EditEmployeeRequest obj) {
        Employee employee = Employee.builder()
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
        employee.setId(obj.getId());
        return employee;
    }
}
