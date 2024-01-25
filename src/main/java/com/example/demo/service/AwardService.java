package com.example.demo.service;

import com.example.demo.rest.dto.award.AwardFull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AwardService {
    ResponseEntity<List<AwardFull>> getAwardsByEmployeeId(Long employeeId);

    void addAward(AwardFull request, Long employeeId);
}
