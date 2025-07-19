package az.unitech.mscurrency.domain.repository;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateRepo extends JpaRepository<ExchangeRate,Long> {
    Optional<ExchangeRate> findByBaseCurrencyAndTargetCurrency(String baseCurrency, String targetCurrency);
}
