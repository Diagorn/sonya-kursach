package com.example.demo.utils.converters.employeeJob;

import com.example.demo.entity.EmployeeJob;
import com.example.demo.rest.dto.employeeJob.EmployeeJobFull;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeJobFullConverter implements Converter<EmployeeJob, EmployeeJobFull> {
    @Override
    public EmployeeJobFull convert(EmployeeJob obj) {
        return EmployeeJobFull.builder()
                .id(obj.getId())
                .employeeFio(obj.getEmployee().getFio())
                .dateEnd(obj.getDateEnd())
                .dateStart(obj.getDateStart())
                .organizationName(obj.getOrganizationName())
                .position(obj.getPosition())
                .salary(obj.getSalary())
                .build();
    }
}
