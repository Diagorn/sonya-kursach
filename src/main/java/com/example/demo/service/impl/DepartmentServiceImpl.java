package com.example.demo.service.impl;

import com.example.demo.entity.Department;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DepartmentRepo;
import com.example.demo.rest.dto.department.DepartmentDto;
import com.example.demo.service.DepartmentService;
import com.example.demo.utils.converters.department.DepartmentConverterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentConverterFactory departmentConverterFactory;
    private final DepartmentRepo departmentRepo;

    @Override
    public List<DepartmentDto> getAllDto() {
        return departmentRepo.findAll().stream()
                .map(department -> departmentConverterFactory.getDepartmentDtoConverter().convert(department))
                .collect(Collectors.toList());
    }

    @Override
    public Department getById(Long id) {
        Optional<Department> department = departmentRepo.findById(id);
        if (department.isEmpty()) {
            throw new NotFoundException("Не удалось найти подразделение с идентификатором " + id);
        }
        return department.get();
    }
}
