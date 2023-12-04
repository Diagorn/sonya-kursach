package com.example.demo.entity.dictionaryEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum AgeGroupEnum {

    YOUNG(1, 18, 30),
    MIDDLE_AGE(2, 31, 50),
    ELDER(3, 51, 90),
    OLD(4, 91, Integer.MAX_VALUE);

    private final int code;
    private final int beginAge;
    private final int endAge;

    public static Optional<AgeGroupEnum> findByCode(int code) {
        return Arrays.stream(values())
                .filter(val -> val.code == code)
                .findFirst();
    }
}
