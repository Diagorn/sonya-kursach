package com.example.demo.repo;

import com.example.demo.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepo extends JpaRepository<Institute, Long> {
}
