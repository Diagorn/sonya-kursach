package com.example.demo.utils.converters.discipline;

import com.example.demo.entity.Discipline;
import com.example.demo.rest.dto.discipline.DisciplineDto;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisciplineDtoConverter implements Converter<Discipline, DisciplineDto> {
    @Override
    public DisciplineDto convert(Discipline obj) {
        return DisciplineDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .build();
    }
}
