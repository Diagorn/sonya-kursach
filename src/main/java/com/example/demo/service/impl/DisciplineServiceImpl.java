package com.example.demo.service.impl;

import com.example.demo.entity.Discipline;
import com.example.demo.entity.Employee;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DisciplineRepo;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.rest.dto.discipline.DisciplineDto;
import com.example.demo.service.DisciplineService;
import com.example.demo.utils.converters.discipline.DisciplineConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepo disciplineRepo;
    private final EmployeeRepo employeeRepo;

    private final DisciplineConverterFactory disciplineConverterFactory;

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

    @Override
    public List<DisciplineDto> getAll() {
        return disciplineRepo.findAll().stream()
                .map(discipline -> disciplineConverterFactory.getDisciplineDtoConverter().convert(discipline))
                .collect(Collectors.toList());
    }

    @Override
    public List<DisciplineDto> getAllForEmployee(Long employeeId) {
        return getByEmployee(employeeRepo.findById(employeeId).orElse(null)).stream()
                .map(discipline -> disciplineConverterFactory.getDisciplineDtoConverter().convert(discipline))
                .collect(Collectors.toList());
    }
}
