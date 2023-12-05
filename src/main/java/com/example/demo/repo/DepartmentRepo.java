package com.example.demo.repo;

import com.example.demo.entity.Department;
import com.example.demo.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByDisciplines(Discipline discipline);
}
