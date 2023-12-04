package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_type")
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_type_seq")
    @SequenceGenerator(name = "employee_type_seq", sequenceName = "employee_type_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeType")
    private List<Employee> employees;
}
