package com.example.demo.repo;

import com.example.demo.entity.EducationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDocumentRepo extends JpaRepository<EducationDocument, Long> {
}
