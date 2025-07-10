package az.unitech.mscurrency.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateDto {
    private String from;
    private String to;
    private BigDecimal rate;
    private LocalDateTime updatedAt;
}
