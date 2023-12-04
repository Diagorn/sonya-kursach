package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractDictionary;
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
public class Discipline extends AbstractDictionary {
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
