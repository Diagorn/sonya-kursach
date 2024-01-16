package com.example.demo.rest.dto.degree;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DegreeResponse {
    private Long id;
    private String name;
}
