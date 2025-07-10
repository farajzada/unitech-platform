package az.unitech.mscurrency.domain.repository;

import az.unitech.mscurrency.domain.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepo extends JpaRepository<CurrencyRate,String> {
}
