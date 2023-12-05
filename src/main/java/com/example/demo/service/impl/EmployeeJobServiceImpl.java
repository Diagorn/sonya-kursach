package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeJob;
import com.example.demo.exception.common.BadRequestException;
import com.example.demo.repo.EmployeeJobRepo;
import com.example.demo.rest.dto.employeeJob.EmployeeJobFull;
import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;
import com.example.demo.service.EmployeeJobService;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.converters.employeeJob.EmployeeJobConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<EmployeeJobFull> getJobsByEmployeeId(Long employeeId) {
        return employeeJobRepo.findAllByEmployeeId(employeeId).stream()
                .map(employeeJob -> employeeJobConverterFactory.getEmployeeJobFullConverter().convert(employeeJob))
                .collect(Collectors.toList());
    }
}
