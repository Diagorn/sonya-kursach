package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.rest.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> getAllDto();

    Department getById(Long id);
}
