package com.example.demo.utils.converters.lesson;

import com.example.demo.entity.Lesson;
import com.example.demo.rest.dto.lesson.LessonInfo;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class LessonInfoConverter implements Converter<Lesson, LessonInfo> {
    @Override
    public LessonInfo convert(Lesson obj) {
        return LessonInfo.builder()
                .id(obj.getId())
                .dateStart(obj.getDateStart())
                .dateEnd(obj.getDateEnd())
                .disciplineName(obj.getDiscipline().getName())
                .groupName(obj.getGroup().getName())
                .room(obj.getRoom())
                .teacherName(obj.getTeacher().getFio())
                .build();
    }
}
