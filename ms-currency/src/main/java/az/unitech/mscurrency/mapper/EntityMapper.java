package az.unitech.mscurrency.mapper;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;

public interface EntityMapper<E,D> {
    D toDto(E entity);
    E toEntity(D dto);
}
