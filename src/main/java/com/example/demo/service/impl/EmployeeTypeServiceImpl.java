package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeType;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.EmployeeTypeRepo;
import com.example.demo.service.EmployeeTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    private final EmployeeTypeRepo employeeTypeRepo;

    @Override
    public EmployeeType findById(Long id) {
        Optional<EmployeeType> type = employeeTypeRepo.findById(id);

        if (type.isEmpty()) {
            throw new NotFoundException("Не найден тип сотрудника по id = " + id);
        }

        return type.get();
    }
}
