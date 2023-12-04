package com.example.demo.repo;

import com.example.demo.entity.Degree;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByFio(String fio);
    List<Employee> findByEmployeeTypeAndContractExpireDateBetween(EmployeeType employeeType, LocalDate from, LocalDate to);
    List<Employee> findAllByDegree(Degree degree);

    List<Employee> findAllByDateOfBirthBetween(LocalDate from, LocalDate to);
}
