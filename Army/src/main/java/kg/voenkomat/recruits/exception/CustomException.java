package kg.voenkomat.recruits.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomException extends RuntimeException {
    Integer statusCode;
    public CustomException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
