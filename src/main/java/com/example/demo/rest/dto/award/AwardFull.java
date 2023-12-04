package com.example.demo.rest.dto.award;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AwardFull {
    private String text;
    private LocalDate dateRecieve;
    private String giverOrganization;
}
