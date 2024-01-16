package com.example.demo.rest.controller;

import com.example.demo.rest.dto.degree.DegreeResponse;
import com.example.demo.service.DegreeService;
import com.example.demo.utils.converters.degree.DegreeConverterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/degree")
@RequiredArgsConstructor
public class DegreeController {

    private final DegreeService degreeService;
    private final DegreeConverterFactory degreeConverterFactory;

    @GetMapping
    public ResponseEntity<List<DegreeResponse>> getAllDegrees() {
        List<DegreeResponse> responseBody = degreeService.getAll().stream()
                .map(degree -> degreeConverterFactory.getDegreeReponseConverter().convert(degree))
                .toList();
        return ResponseEntity.ok(responseBody);
    }
}
