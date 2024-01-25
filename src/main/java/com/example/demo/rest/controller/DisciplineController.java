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
    private final DisciplineService disciplineService;

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getAll() {
        return ResponseEntity.ok(disciplineService.getAll());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<DisciplineDto>> getAllForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(disciplineService.getAllForEmployee(employeeId));
    }

    @GetMapping("/employee/{employeeId}/missing")
    public ResponseEntity<List<DisciplineDto>> getAllMissingDisciplinesForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getAllDtoExcludingEmployees(employeeId));
    }
}
