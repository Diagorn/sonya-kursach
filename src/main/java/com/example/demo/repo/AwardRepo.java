package com.example.demo.repo;

import com.example.demo.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepo extends JpaRepository<Award, Long> {
    List<Award> findAllByEmployeeId(Long employeeId);
}
