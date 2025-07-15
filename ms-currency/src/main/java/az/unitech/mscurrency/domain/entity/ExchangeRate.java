package az.unitech.mscurrency.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(sequenceName = "seq",name = "seq",allocationSize = 1)
    private Long id;

    @Column(nullable = false,length = 3)
    private String baseCurrency;

    @Column(nullable = false,length = 3)
    private String targetCurrency;

    @Column(nullable = false,precision = 12,scale = 6)
    private BigDecimal rate;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Long timestamp;
}
