package kg.voenkomat.recruits.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        String errorUUID = UUID.randomUUID().toString();
        log.error("Error: {}, UUID: {}", ex.getMessage(), errorUUID);

        ErrorResponse errorResponse = new ErrorResponse(
                ex.getHttpStatus(),
                ex.getMessage(),
                errorUUID
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getHttpStatus()));
    }
}