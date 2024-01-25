package com.example.demo.rest.dto.group;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupInfo {
    private Long id;
    private String name;
}
