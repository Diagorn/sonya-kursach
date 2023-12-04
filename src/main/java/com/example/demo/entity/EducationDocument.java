package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "education_document")
public class EducationDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_document_seq")
    @SequenceGenerator(name = "education_document_seq", sequenceName = "education_document_seq", allocationSize = 1)
    private Long id;
    @Column(name = "serie", nullable = false, length = 15)
    private String serie;
    @Column(name = "number", nullable = false, length = 15)
    private String number;
    @Column(name = "university_name", length = 255)
    private String universityName;
    @Column(name = "giving_date", nullable = false)
    private LocalDate givingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}


