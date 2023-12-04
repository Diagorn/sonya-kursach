package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeJob;
import com.example.demo.exception.common.BadRequestException;
import com.example.demo.repo.EmployeeJobRepo;
import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;
import com.example.demo.service.EmployeeJobService;
import com.example.demo.utils.converters.employeeJob.EmployeeJobConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeJobServiceImpl implements EmployeeJobService {

    private final EmployeeJobRepo employeeJobRepo;

    private final EmployeeJobConverterFactory employeeJobConverterFactory;

    @Override
    public void addNewJob(Long employeeId, NewEmployeeJobRequest request) {
        Optional<EmployeeJob> lastJob = employeeJobRepo.findByEmployeeIdAndDateEndNull(employeeId);
        if (lastJob.isEmpty()) {
            throw new BadRequestException("У сотрудника с id = " + employeeId + " не найдено последней работы");
        }

        EmployeeJob employeeLastJob = lastJob.get();
        employeeLastJob.setDateEnd(LocalDate.now());
        employeeJobRepo.save(employeeLastJob);

        EmployeeJob newJob = employeeJobConverterFactory.getNewEmployeeJobConverter().convert(request);
        newJob.setEmployee(employeeLastJob.getEmployee());
        employeeJobRepo.save(newJob);
    }
}
