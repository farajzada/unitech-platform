package az.unitech.mscurrency.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateDto implements Serializable {
    private Long id;
    private String from;
    private String to;
    private BigDecimal rate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
}
