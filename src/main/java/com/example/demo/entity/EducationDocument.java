package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractEntity;
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
public class EducationDocument extends AbstractEntity {
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


