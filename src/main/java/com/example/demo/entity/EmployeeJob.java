package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "employee_job")
public class EmployeeJob extends AbstractEntity {
    @Column(name = "position", nullable = false, length = 127)
    private String position;
    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
    @Column(name = "date_end", nullable = true)
    private LocalDate dateEnd;
    @Column(name = "organization_name", nullable = false, length = 255)
    private String organizationName;
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
