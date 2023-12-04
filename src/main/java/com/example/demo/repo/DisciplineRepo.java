package com.example.demo.repo;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepo extends JpaRepository<Discipline, Long> {
    List<Discipline> findAllByEmployeesContaining(Employee employee);
}
