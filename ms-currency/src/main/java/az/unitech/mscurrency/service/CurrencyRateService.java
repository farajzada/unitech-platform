package az.unitech.mscurrency.service;

import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.request.ExchangeRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyRateService {
    List<ExchangeRateDto> getAllRates();
    ExchangeRateDto createRate(CreateRateRequest createRateRequest);
    ExchangeRateDto getRate(ExchangeRateRequest exchangeRateRequest);
    ExchangeRateDto updateRate(ExchangeRateRequest exchangeRateRequest, BigDecimal rate);
    void deleteRate(ExchangeRateRequest exchangeRateRequest);
    void deleteRateById(Long id);
    ExchangeRateDto getRateById(Long id);
}
