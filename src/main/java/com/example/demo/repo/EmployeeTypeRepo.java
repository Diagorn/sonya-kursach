package com.example.demo.repo;

import com.example.demo.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, Long> {
}
