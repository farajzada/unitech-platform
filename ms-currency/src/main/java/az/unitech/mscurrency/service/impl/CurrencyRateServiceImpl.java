package az.unitech.mscurrency.service.impl;

import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import az.unitech.mscurrency.service.CurrencyRateService;

import java.math.BigDecimal;
import java.util.List;

public class CurrencyRateServiceImpl implements CurrencyRateService {
    @Override
    public List<ExchangeRateDto> getAllRates() {
        return List.of();
    }

    @Override
    public ExchangeRateDto createRate(CreateRateRequest createRateRequest) {
        return null;
    }

    @Override
    public ExchangeRateDto getRate(String from, String to) {
        return null;
    }

    @Override
    public ExchangeRateDto updateRate(String from, String to, BigDecimal rate) {
        return null;
    }

    @Override
    public void deleteRate(String from, String to) {

    }

    @Override
    public void deleteRateById(Long id) {

    }
}
