package az.unitech.mscurrency.mapper;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Component
public class ExchangeRateMapper  {

    public ExchangeRate toEntity(ExchangeRateDto dto){
        if(dto == null) return null;

        return ExchangeRate.builder()
                .rate(dto.getRate())
                .date(LocalDate.now())
                .targetCurrency(dto.getTo())
                .baseCurrency(dto.getFrom())
                .timestamp(dto.getUpdatedAt() != null ? dto.getUpdatedAt().atStartOfDay().toEpochSecond(ZoneOffset.UTC) : null)
                .build();
    }

    public ExchangeRateDto toDto(ExchangeRate entity){
        if(entity == null) return null;

        return ExchangeRateDto.builder()
                .rate(entity.getRate())
                .from(entity.getBaseCurrency())
                .to(entity.getTargetCurrency())
                .updatedAt(entity.getDate())
                .build();
    }

    public ExchangeRate toEntity(CreateRateRequest createRateRequest){
        if(createRateRequest == null) return null;

        return ExchangeRate.builder()
                .rate(createRateRequest.getRate())
                .baseCurrency(createRateRequest.getBaseCurrency())
                .targetCurrency(createRateRequest.getTargetCurrency())
                .date(LocalDate.now())
                .build();
    }
}
