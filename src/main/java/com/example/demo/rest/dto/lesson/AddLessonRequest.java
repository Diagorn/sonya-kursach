package com.example.demo.rest.dto.lesson;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AddLessonRequest {
    private LocalDateTime dateBegin;
    private LocalDateTime dateEnd;
    private String room;
    private Long disciplineId;
    private Long groupId;
    private Long teacherId;
}
