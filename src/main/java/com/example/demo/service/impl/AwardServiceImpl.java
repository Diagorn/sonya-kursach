package com.example.demo.service.impl;

import com.example.demo.repo.AwardRepo;
import com.example.demo.rest.dto.award.AwardFull;
import com.example.demo.service.AwardService;
import com.example.demo.utils.converters.award.AwardConverterFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwardServiceImpl implements AwardService {

    private final AwardRepo awardRepo;

    private final AwardConverterFactory awardConverterFactory;

    @Override
    public ResponseEntity<List<AwardFull>> getAwardsByEmployeeId(Long employeeId) {
        List<AwardFull> awards = awardRepo.findAllByEmployeeId(employeeId).stream()
                .map(award -> awardConverterFactory.getAwardFullConverter().convert(award))
                .toList();

        return ResponseEntity.ok(awards);
    }
}
