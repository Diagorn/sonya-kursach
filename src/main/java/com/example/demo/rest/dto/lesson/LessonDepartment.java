package com.example.demo.rest.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class LessonDepartment {
    private String departmentName;
    private List<LessonInfo> lessons;
}
