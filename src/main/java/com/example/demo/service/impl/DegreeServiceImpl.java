package com.example.demo.service.impl;

import com.example.demo.entity.Degree;
import com.example.demo.exception.common.NotFoundException;
import com.example.demo.repo.DegreeRepo;
import com.example.demo.service.DegreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DegreeServiceImpl implements DegreeService {

    private final DegreeRepo degreeRepo;

    @Override
    public Degree getById(Long id) {
        Optional<Degree> degree = degreeRepo.findById(id);

        if (degree.isEmpty()) {
            throw new NotFoundException("Не найдена учёная степень по id = " + id);
        }

        return degree.get();
    }
}
