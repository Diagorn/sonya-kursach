package com.example.demo.repo;

import com.example.demo.entity.EmployeeJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeJobRepo extends JpaRepository<EmployeeJob, Long> {
    Optional<EmployeeJob> findByEmployeeIdAndDateEndNull(Long id);

    List<EmployeeJob> findAllByEmployeeId(Long id);
}
