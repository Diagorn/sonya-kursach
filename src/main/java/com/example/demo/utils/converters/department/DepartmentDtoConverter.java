package com.example.demo.utils.converters.department;

import com.example.demo.entity.Department;
import com.example.demo.rest.dto.department.DepartmentDto;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoConverter implements Converter<Department, DepartmentDto> {
    @Override
    public DepartmentDto convert(Department obj) {
        return DepartmentDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .build();
    }
}
