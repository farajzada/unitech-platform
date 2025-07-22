package az.unitech.mscurrency.service.impl;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.domain.repository.ExchangeRateRepo;
import az.unitech.mscurrency.dto.request.CreateRateRequest;
import az.unitech.mscurrency.dto.request.ExchangeRateRequest;
import az.unitech.mscurrency.dto.response.ExchangeRateDto;
import az.unitech.mscurrency.exception.RateNotFoundException;
import az.unitech.mscurrency.mapper.ExchangeRateMapper;
import az.unitech.mscurrency.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    @CacheEvict(value = "rates", allEntries = true)
    public ExchangeRateDto createRate(CreateRateRequest createRateRequest) {
        ExchangeRate exchangeRate=exchangeRateMapper.toEntity(createRateRequest);
        ExchangeRate savedRate=exchangeRateRepo.save(exchangeRate);
        return exchangeRateMapper.toDto(savedRate);
    }

    @Override
    @Cacheable("rates")
    public ExchangeRateDto getRate(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate exchangeRate=rateFind(exchangeRateRequest.getFrom(), exchangeRateRequest.getTo());
        return exchangeRateMapper.toDto(exchangeRate);
    }

    @Override
    @CacheEvict(value = "rates",allEntries = true)
    public ExchangeRateDto updateRate(ExchangeRateRequest exchangeRateRequest, BigDecimal rate) {
        ExchangeRate exchangeRate=rateFind(exchangeRateRequest.getFrom(), exchangeRateRequest.getTo());
        exchangeRate.setRate(rate);
        ExchangeRate savedRate=exchangeRateRepo.save(exchangeRate);
        return exchangeRateMapper.toDto(savedRate);
    }

    @Override
    @CacheEvict(value = "rates", allEntries = true)
    public void deleteRate(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate exchangeRate=rateFind(exchangeRateRequest.getFrom(), exchangeRateRequest.getTo());
        exchangeRateRepo.delete(exchangeRate);
    }

    @Override
    @CacheEvict(value = "rates", allEntries = true)
    public void deleteRateById(Long id) {
        exchangeRateRepo.deleteById(id);
    }

    public ExchangeRate rateFind(String from,String to){
        return exchangeRateRepo.findByBaseCurrencyAndTargetCurrency(from,to)
                .orElseThrow(()-> new RateNotFoundException("Exchange rate not found for "+from+" to "+to));    }
}
