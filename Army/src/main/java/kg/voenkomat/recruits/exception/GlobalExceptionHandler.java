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
//        log.error(ex.getMessage(), UUID.randomUUID().toString();
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                ex.getStatusCode()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Ошибка: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}