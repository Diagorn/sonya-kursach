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
@Table(name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "degree_seq")
    @SequenceGenerator(name = "degree_seq", sequenceName = "degree_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "degree")
    private List<Employee> employees;
}
