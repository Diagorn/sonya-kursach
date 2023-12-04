package com.example.demo.service;

import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;

public interface EmployeeJobService {
    void addNewJob(Long employeeId, NewEmployeeJobRequest request);
}
