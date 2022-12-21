package com.digitalbooks.exception;

import com.digitalbooks.enums.ErrorCodes;
import com.digitalbooks.exception.errors.Error;
import com.digitalbooks.exception.errors.ErrorDetails;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GlobalException extends RuntimeException{

    private int status ;

    private Error error ;

    public GlobalException(ErrorCodes errorCode)
    {
        this.status = errorCode.getCode();
        ErrorDetails errorDetails = ErrorDetails.builder()
                .errorCode(errorCode.name().replace("-" , "_"))
                .message(errorCode.getMessage())
                .build();
        error = Error.builder()
                .errorDetails(errorDetails)
                .status(status)
                .build();
    }
}
