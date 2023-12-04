package com.example.demo.rest.controller;

import com.example.demo.rest.dto.award.AwardFull;
import com.example.demo.service.AwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/award")
@RequiredArgsConstructor
public class AwardController {

    private final AwardService awardService;

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AwardFull>> awardsByEmployee(@PathVariable Long employeeId) {
        return awardService.getAwardsByEmployeeId(employeeId);
    }
}
