package com.example.demo.utils.converters.employeeJob;

import com.example.demo.entity.EmployeeJob;
import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NewEmployeeJobConverter implements Converter<NewEmployeeJobRequest, EmployeeJob> {
    @Override
    public EmployeeJob convert(NewEmployeeJobRequest obj) {
        return EmployeeJob.builder()
                .dateStart(LocalDate.now())
                .dateEnd(null)
                .organizationName("НИУ МЭИ")
                .position(obj.getPosition())
                .salary(obj.getSalary())
                .build();
    }
}
