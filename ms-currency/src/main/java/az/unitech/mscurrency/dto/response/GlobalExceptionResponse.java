package az.unitech.mscurrency.dto.response;

import az.unitech.mscurrency.exception.ErrorMessage;

import java.time.LocalDateTime;
import java.util.UUID;

public class GlobalExceptionResponse {
    private UUID uuid;
    private String message;
    private ErrorMessage error;
    private LocalDateTime timestamp;
}
