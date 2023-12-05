package com.example.demo.service;

import com.example.demo.rest.dto.employeeJob.EmployeeJobFull;
import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;

import java.util.List;

public interface EmployeeJobService {
    void addNewJob(Long employeeId, NewEmployeeJobRequest request);

    List<EmployeeJobFull> getJobsByEmployeeId(Long employeeId);
}
