package az.unitech.mscurrency.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateDto {
    private String from;
    private String to;
    private BigDecimal rate;
    private LocalDate updatedAt;
}
