package az.unitech.mscurrency.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponse {
    private BigDecimal convertedAmount;
    private String fromCode;
    private String toCode;
    private BigDecimal rateUsed;
}
