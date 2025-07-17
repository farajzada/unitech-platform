package az.unitech.mscurrency.service;

import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyRateService {
    List<ExchangeRateDto> getAllRates();
    ExchangeRateDto createRate(CreateRateRequest createRateRequest);
    ExchangeRateDto getRate(String from, String to);
    ExchangeRateDto updateRate(String from, String to, BigDecimal rate);
    void deleteRate(String from, String to);
    void deleteRateById(Long id);
}
