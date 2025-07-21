package az.unitech.mscurrency.service.impl;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.domain.repository.ExchangeRateRepo;
import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import az.unitech.mscurrency.exception.RateNotFoundException;
import az.unitech.mscurrency.mapper.ExchangeRateMapper;
import az.unitech.mscurrency.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final ExchangeRateRepo exchangeRateRepo;
    private final ExchangeRateMapper exchangeRateMapper;

    @Override
    @Cacheable("rates")
    public List<ExchangeRateDto> getAllRates() {
        List<ExchangeRate> list= exchangeRateRepo.findAll();
        return list.stream()
                .map(exchangeRateMapper::toDto)
                .collect(Collectors.toList());
    }

    @Cacheable("rates")
    @Override
    public ExchangeRateDto createRate(CreateRateRequest createRateRequest) {
        ExchangeRate exchangeRate=exchangeRateMapper.toEntity(createRateRequest);
        exchangeRate.setDate(LocalDate.now());
        ExchangeRate savedRate=exchangeRateRepo.save(exchangeRate);
        return exchangeRateMapper.toDto(savedRate);
    }

    @Override
    @Cacheable("rates")
    public ExchangeRateDto getRate(String from, String to) {
        ExchangeRate exchangeRate=rateFind(from,to);
        return exchangeRateMapper.toDto(exchangeRate);
    }

    @Override
    public ExchangeRateDto updateRate(String from, String to, BigDecimal rate) {
        ExchangeRate exchangeRate=rateFind(from, to);
        exchangeRate.setRate(rate);
        ExchangeRate savedRate=exchangeRateRepo.save(exchangeRate);
        return exchangeRateMapper.toDto(savedRate);
    }

    @Override
    public void deleteRate(String from, String to) {
        ExchangeRate exchangeRate=rateFind(from, to);
        exchangeRateRepo.delete(exchangeRate);
    }

    @Override
    public void deleteRateById(Long id) {
        exchangeRateRepo.deleteById(id);
    }

    public ExchangeRate rateFind(String from,String to){
        return exchangeRateRepo.findByBaseCurrencyAndTargetCurrency(from,to)
                .orElseThrow(()-> new RateNotFoundException("Exchange rate not found for "+from+" to "+to));    }
}
