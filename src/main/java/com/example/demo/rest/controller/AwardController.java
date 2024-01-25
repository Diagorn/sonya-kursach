package com.example.demo.rest.controller;

import com.example.demo.rest.dto.award.AwardFull;
import com.example.demo.service.AwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<AwardFull> addAward(@PathVariable Long employeeId, @RequestBody AwardFull request) {
        awardService.addAward(request, employeeId);
        return ResponseEntity.ok(request);
    }
}
