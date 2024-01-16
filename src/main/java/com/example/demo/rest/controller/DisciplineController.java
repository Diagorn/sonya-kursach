package com.example.demo.rest.controller;

import com.example.demo.rest.dto.discipline.DisciplineDto;
import com.example.demo.service.DisciplineService;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discipline")
@RequiredArgsConstructor
public class DisciplineController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/{employeeId}/missing")
    public ResponseEntity<List<DisciplineDto>> getAllMissingDisciplinesForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getAllDtoExcludingEmployees(employeeId));
    }
}
