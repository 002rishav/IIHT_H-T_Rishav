package com.digitalbooks.exception.errors;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Error {

    private int status ;

    private ErrorDetails errorDetails ;
}
