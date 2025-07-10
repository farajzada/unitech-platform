package az.unitech.mscurrency.domain.repository;

import az.unitech.mscurrency.domain.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepo extends JpaRepository<ExchangeRate,Long> {
}
