package com.example.demo.utils.converters.degree;

import com.example.demo.rest.dto.degree.DegreeResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class DegreeConverterFactory {

    private final DegreeReponseConverter degreeReponseConverter;
}
