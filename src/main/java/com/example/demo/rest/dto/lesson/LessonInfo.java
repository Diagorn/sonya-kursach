package com.example.demo.rest.dto.lesson;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LessonInfo {
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String room;
    private String disciplineName;
    private String groupName;
    private String teacherName;
}
