package com.example.demo.rest.controller;

import com.example.demo.rest.dto.employeeJob.EmployeeJobFull;
import com.example.demo.rest.dto.employeeJob.NewEmployeeJobRequest;
import com.example.demo.service.EmployeeJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employeeJob")
@RequiredArgsConstructor
public class EmployeeJobController {

    private final EmployeeJobService employeeJobService;

    @PostMapping("/{employeeId}/add")
    public void addNewJob(@PathVariable Long employeeId, @RequestBody NewEmployeeJobRequest request) {
        employeeJobService.addNewJob(employeeId, request);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeJobFull>> getEmployeeJobs(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeJobService.getJobsByEmployeeId(employeeId));
    }
}
