package az.unitech.mscurrency.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateRequest {
    @NotBlank
    private String from;

    @NotBlank
    private String to;
}
