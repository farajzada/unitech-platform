package az.unitech.mscurrency.dto.response;

import az.unitech.mscurrency.exception.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalExceptionResponse {
    private UUID uuid;
    private String message;
    private ErrorMessage error;
    private LocalDateTime timestamp;
}
