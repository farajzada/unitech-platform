package az.unitech.mscurrency.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateRequest {
    private String fromCode;
    private String toCode;
    private BigDecimal amount;
}
