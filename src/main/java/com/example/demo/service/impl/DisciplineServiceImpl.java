package com.example.demo.service.impl;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DisciplineRepo;
import com.example.demo.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepo disciplineRepo;

    @Override
    public List<Discipline> getByEmployee(Employee employee) {
        return disciplineRepo.findAllByEmployeesContaining(employee);
    }

    @Override
    public Discipline getById(Long disciplineId) {
        Optional<Discipline> discipline = disciplineRepo.findById(disciplineId);

        if (discipline.isEmpty()) {
            throw new NotFoundException("Не найдена дисциплина с id = " + disciplineId);
        }

        return discipline.get();
    }

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineRepo.findAll();
    }
}
