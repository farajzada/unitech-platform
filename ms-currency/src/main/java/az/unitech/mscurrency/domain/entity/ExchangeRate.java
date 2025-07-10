package az.unitech.mscurrency.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {

    @Id
    private Long id;

    @Column(nullable = false,length = 3)
    private String baseCurrency;

    @Column(nullable = false,length = 3)
    private String targetCurrency;

    @Column(nullable = false,precision = 12,scale = 6)
    private BigDecimal rate;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
