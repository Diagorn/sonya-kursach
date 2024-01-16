package com.example.demo.service;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.discipline.DisciplineDto;

import java.util.List;

public interface DisciplineService {
    List<Discipline> getByEmployee(Employee employee);

    Discipline getById(Long disciplineId);

    List<Discipline> getAllDisciplines();


}
