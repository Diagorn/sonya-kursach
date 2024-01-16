package com.example.demo.utils.converters.degree;

import com.example.demo.entity.Degree;
import com.example.demo.rest.dto.degree.DegreeResponse;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class DegreeReponseConverter implements Converter<Degree, DegreeResponse> {
    @Override
    public DegreeResponse convert(Degree obj) {
        return DegreeResponse.builder()
                .id(obj.getId())
                .name(obj.getName())
                .build();
    }
}
