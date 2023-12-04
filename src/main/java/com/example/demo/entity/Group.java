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
@Table(name = "learning_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "learning_group_seq")
    @SequenceGenerator(name = "learning_group_seq", sequenceName = "learning_group_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<Lesson> lessons;
}
