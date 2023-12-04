package com.example.demo.entity.dictionaryEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmployeeTypeEnum {
    PPS(1L, "Профессорско-преподавательский состав"),
    BOSS(2L, "Руководитель"),
    ADDITIONAL(3L, "Вспомогательный персонал");

    private final Long id;
    private final String name;
}
