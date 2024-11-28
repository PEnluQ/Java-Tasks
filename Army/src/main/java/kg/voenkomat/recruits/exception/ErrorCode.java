package kg.voenkomat.recruits.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    RESOURCE_NOT_FOUND(404, "Not Found"),
    RESOURCE_CONFLICT(409, "Conflict"),

    VALIDATION_ERROR(400, "Bad Request"),

    ACCESS_DENIED(403, "Access Denied"),
    UNAUTHORIZED(401, "Unauthorized"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    private final int httpStatus;
    private final String message;
}
