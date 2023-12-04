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
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_seq")
    @SequenceGenerator(name = "discipline_seq", sequenceName = "discipline_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "discipline")
    private List<Lesson> lessons;
    @ManyToMany
    @JoinTable(
            name = "employee_discipline",
            inverseJoinColumns = @JoinColumn(name = "employee_id"),
            joinColumns = @JoinColumn(name = "discipline_id")
    )
    private List<Employee> employees;
}
