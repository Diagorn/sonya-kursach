package com.example.demo.service;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeJob;
import com.example.demo.rest.dto.degree.NewDegreeRequest;
import com.example.demo.rest.dto.discipline.DisciplineDto;
import com.example.demo.rest.dto.employee.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    ResponseEntity<List<EmployeeFull>> getAll();

    ResponseEntity<EmployeeFull> add(AddEmployeeRequest request);

    ResponseEntity<List<EmployeeFull>> findByFio(String fio);

    ResponseEntity<List<EmployeeFull>> findAllWithContractEndingThisYear();

    Employee getById(Long employeeId);

    EmployeeFull getEmpById(Long employeeId);

    void changeDegree(Long employeeId, NewDegreeRequest request);

    ResponseEntity<?> edit(EditEmployeeRequest request);

    ResponseEntity<?> delete(Long employeeId);

    ResponseEntity<List<EmployeeDiscipline>> getEmployeeDisciplinesById(Long employeeId);

    ResponseEntity<List<EmployeeFull>> getAllByDegreeId(Long degreeId);

    ResponseEntity<List<EmployeeFull>> getAllByAgeGroup(int ageCode);

    void addDiscipline(AddEmployeeDisciplineRequest request);

    List<Discipline> getAllExcludingEmployees(Employee employee);

    List<DisciplineDto> getAllDtoExcludingEmployees(Employee employee);

    List<DisciplineDto> getAllDtoExcludingEmployees(Long employeeId);
}
