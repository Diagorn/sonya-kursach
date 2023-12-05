package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeJob;
import com.example.demo.rest.dto.degree.NewDegreeRequest;
import com.example.demo.rest.dto.employee.AddEmployeeRequest;
import com.example.demo.rest.dto.employee.EditEmployeeRequest;
import com.example.demo.rest.dto.employee.EmployeeDiscipline;
import com.example.demo.rest.dto.employee.EmployeeFull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<EmployeeFull>> getAll();

    ResponseEntity<EmployeeFull> add(AddEmployeeRequest request);

    ResponseEntity<EmployeeFull> findByFio(String fio);

    ResponseEntity<List<EmployeeFull>> findAllWithContractEndingThisYear();

    Employee getById(Long employeeId);

    void changeDegree(Long employeeId, NewDegreeRequest request);

    ResponseEntity<?> edit(EditEmployeeRequest request);

    ResponseEntity<?> delete(Long employeeId);

    ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesByFio(String employeeFio);

    ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesById(Long employeeId);

    ResponseEntity<List<EmployeeFull>> getAllByDegreeId(Long degreeId);

    ResponseEntity<List<EmployeeFull>> getAllByAgeGroup(int ageCode);
}
