package com.example.book.exception;


import com.example.book.enums.ErrorCodes;
import com.example.book.exception.errors.Error;
import com.example.book.exception.errors.ErrorDetails;
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
