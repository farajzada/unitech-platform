package az.unitech.mscurrency.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto {
    private boolean success;
    private String base;
    private LocalDate date;
    private Long timestamp;
    private Map<String,BigDecimal> rates;
}
