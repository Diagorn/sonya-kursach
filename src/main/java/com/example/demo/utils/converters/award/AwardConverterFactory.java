package com.example.demo.utils.converters.award;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class AwardConverterFactory {
    private final AwardFullConverter awardFullConverter;
}
