package az.unitech.mscurrency.exception;

import az.unitech.mscurrency.dto.response.GlobalExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CurrencyFetchException.class)
    public ResponseEntity<GlobalExceptionResponse> currencyFetchHandler(CurrencyFetchException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                GlobalExceptionResponse.builder()
                        .uuid(UUID.randomUUID())
                        .error(ErrorMessage.CURRENCY_FETCH_FAILED)
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @ExceptionHandler(RateNotFoundException.class)
    public ResponseEntity<GlobalExceptionResponse> currencyFetchHandler(RateNotFoundException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                GlobalExceptionResponse.builder()
                        .uuid(UUID.randomUUID())
                        .error(ErrorMessage.RATE_NOT_FOUND)
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @ExceptionHandler(CurrencyFetchException.class)
    public ResponseEntity<GlobalExceptionResponse> currencyFetchHandler(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                GlobalExceptionResponse.builder()
                        .uuid(UUID.randomUUID())
                        .error(ErrorMessage.BAD_REQUEST)
                        .message(exception.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
