package az.unitech.mscurrency.mapper;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;

import java.time.LocalDate;
import java.time.ZoneOffset;

public class ExchangeRateMapper  {

    ExchangeRate toEntity(ExchangeRateDto dto){
        if(dto == null) return null;

        return ExchangeRate.builder()
                .rate(dto.getRate())
                .date(LocalDate.now())
                .targetCurrency(dto.getTo())
                .baseCurrency(dto.getFrom())
                .timestamp(dto.getUpdatedAt() != null ? dto.getUpdatedAt().atStartOfDay().toEpochSecond(ZoneOffset.UTC) : null)
                .build();
    }


    ExchangeRateDto toDto(ExchangeRate entity){
        if(entity == null) return null;

        return ExchangeRateDto.builder()
                .rate(entity.getRate())
                .from(entity.getBaseCurrency())
                .to(entity.getTargetCurrency())
                .updatedAt(LocalDate.now())
                .build();
    }
}
