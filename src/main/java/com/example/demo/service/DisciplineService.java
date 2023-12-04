package com.example.demo.service;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getByEmployee(Employee employee);
}
