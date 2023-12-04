package com.example.demo.repo;

import com.example.demo.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepo extends JpaRepository<Degree, Long> {
}
