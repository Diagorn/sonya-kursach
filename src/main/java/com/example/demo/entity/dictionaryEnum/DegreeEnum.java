package com.example.demo.entity.dictionaryEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DegreeEnum {
    MIDDLE(1L, "Среднее"),
    MIDDLE_SPECIAL(2L, "Среднее специальное"),
    BACHELOR(3L, "Бакалавр"),
    MASTER(4L, "Магистр"),
    CANDIDATE(5L, "Кандидат наук"),
    DOCTOR(6L, "Доктор наук");

    private final Long id;
    private final String name;
}
