package com.example.demo.service;

import com.example.demo.entity.Degree;
import com.example.demo.rest.dto.degree.NewDegreeRequest;

import java.util.List;

public interface DegreeService {
    Degree getById(Long id);

    List<Degree> getAll();
}
