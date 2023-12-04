package com.example.demo.utils.converters.award;

import com.example.demo.entity.Award;
import com.example.demo.rest.dto.award.AwardFull;
import com.example.demo.utils.converters.Converter;
import org.springframework.stereotype.Component;

@Component
public class AwardFullConverter implements Converter<Award, AwardFull> {
    @Override
    public AwardFull convert(Award obj) {
        return AwardFull.builder()
                .text(obj.getText())
                .dateRecieve(obj.getDateRecieve())
                .giverOrganization(obj.getGiverOrganization())
                .build();
    }
}
