package com.example.demo.entity;

import com.example.demo.entity.parent.AbstractDictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Degree extends AbstractDictionary {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "degree")
    private List<Employee> employees;
}
