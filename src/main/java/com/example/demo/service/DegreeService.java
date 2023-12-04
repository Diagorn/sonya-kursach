package com.example.demo.service;

import com.example.demo.entity.Degree;
import com.example.demo.rest.dto.degree.NewDegreeRequest;

public interface DegreeService {
    Degree getById(Long id);
}
