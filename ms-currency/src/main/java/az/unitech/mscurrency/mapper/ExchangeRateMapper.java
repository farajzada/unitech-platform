package az.unitech.mscurrency.mapper;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper extends EntityMapper<ExchangeRate, ExchangeRateDto> {
    @Mapping(source = "from",target = "baseCurrency")
    @Mapping(source = "to",target = "targetCurrency")
    ExchangeRate toEntity(ExchangeRateDto dto);

    @Mapping(source = "baseCurrency",target = "from")
    @Mapping(source = "targetCurrency",target = "to")
    ExchangeRateDto toDto(ExchangeRate entity);
}
