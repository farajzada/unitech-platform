package az.unitech.mscurrency.domain.repository;

import az.unitech.mscurrency.domain.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<Currency,String> {
}
