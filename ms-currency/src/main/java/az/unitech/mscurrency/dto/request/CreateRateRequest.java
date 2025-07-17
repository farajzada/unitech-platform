package az.unitech.mscurrency.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRateRequest {
    @NotBlank
    private String baseCurrency;

    @NotBlank
    private String targetCurrency;

    private BigDecimal rate;
    private LocalDate date;
}
