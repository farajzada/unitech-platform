package az.unitech.mscurrency.service.sync;

import az.unitech.mscurrency.client.CurrencyApiClient;
import az.unitech.mscurrency.domain.entity.ExchangeRate;
import az.unitech.mscurrency.domain.repository.ExchangeRateRepo;
import az.unitech.mscurrency.dto.response.ApiResponseDto;
import az.unitech.mscurrency.exception.CurrencyFetchException;
import az.unitech.mscurrency.exception.RateNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class RateSyncService {
    private final CurrencyApiClient currencyApiClient;
    private final ExchangeRateRepo exchangeRateRepo;
    private final RedisTemplate<String,Object> redisTemplate;

    @Scheduled(fixedRate = 3600000)
    public void sync() {
        ApiResponseDto responseDto = currencyApiClient.getLatestRates("4551f9fa9b38ad61327f6d4d5a6d380c", 1);

        boolean success = responseDto.isSuccess();
        Map<String, BigDecimal> rates = responseDto.getRates();

        if (!success || rates == null || rates.isEmpty()) {
            throw new CurrencyFetchException("Failed to fetch currency data from external API");
        }
        String base = responseDto.getBase();
        Long timestamp = responseDto.getTimestamp();
        LocalDate date = LocalDate.now();

        List<ExchangeRate> exchangeRateList = new ArrayList<>();

        for (Map.Entry<String, BigDecimal> entry : rates.entrySet()) {
            ExchangeRate exchangeRate = ExchangeRate.builder()
                    .rate(entry.getValue())
                    .timestamp(timestamp)
                    .baseCurrency(base)
                    .targetCurrency(entry.getKey())
                    .date(date)
                    .build();

            exchangeRateList.add(exchangeRate);

            String redisKey=entry.getKey()+":"+entry.getValue();
            redisTemplate.opsForValue().set(redisKey,exchangeRate);
        }
        exchangeRateRepo.saveAll(exchangeRateList);
    }
}
