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
@Table(name = "department")
public class Department extends AbstractDictionary {
    @Column(name = "foundation_year")
    private Integer foundationYear;
    @Column(name = "room", length = 10)
    private String room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "institute_id")
    private Institute institute;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private List<Discipline> disciplines;
    @ManyToMany
    @JoinTable(
            name = "employee_department",
            inverseJoinColumns = @JoinColumn(name = "employee_id"),
            joinColumns = @JoinColumn(name = "department_id")
    )
    private List<Employee> employees;
}
