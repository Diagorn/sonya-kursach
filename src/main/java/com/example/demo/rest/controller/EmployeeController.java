package com.example.demo.rest.controller;

import com.example.demo.rest.dto.degree.NewDegreeRequest;
import com.example.demo.rest.dto.employee.*;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeFull>> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public ResponseEntity<EmployeeFull> add(@RequestBody AddEmployeeRequest request) {
        return employeeService.add(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeFull> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmpById(id));
    }

    @GetMapping("/fio/{fio}")
    public ResponseEntity<List<EmployeeFull>> getByFio(@PathVariable String fio) {
        return employeeService.findByFio(fio);
    }

    @GetMapping("/contractEnding")
    public ResponseEntity<List<EmployeeFull>> findAllWithContractEndingThisYear() {
        return employeeService.findAllWithContractEndingThisYear();
    }

    @PostMapping("/{employeeId}/degree")
    public ResponseEntity<?> changeEmployeeDegree(@PathVariable Long employeeId, @RequestBody NewDegreeRequest request) {
        employeeService.changeDegree(employeeId, request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<?> edit(@RequestBody EditEmployeeRequest request) {
        return employeeService.edit(request);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> delete(@PathVariable Long employeeId) {
        return employeeService.delete(employeeId);
    }

    @GetMapping("/id/{employeeId}/disciplines")
    public ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeDisciplinesById(employeeId);
    }

    @GetMapping("/degree/{degreeId}")
    public ResponseEntity<List<EmployeeFull>> getEmployeesByDegreeId(@PathVariable Long degreeId) {
        return employeeService.getAllByDegreeId(degreeId);
    }

    @GetMapping("/age/{ageCode}")
    public ResponseEntity<List<EmployeeFull>> getEmployeesByAgeGroup(@PathVariable int ageCode) {
        return employeeService.getAllByAgeGroup(ageCode);
    }

    @PostMapping("/addDiscipline")
    public ResponseEntity<?> addDiscipline(@RequestBody AddEmployeeDisciplineRequest request) {
        employeeService.addDiscipline(request);
        return ResponseEntity.ok().build();
    }
}
