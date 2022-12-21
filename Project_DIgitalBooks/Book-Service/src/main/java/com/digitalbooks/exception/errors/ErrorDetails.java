package com.digitalbooks.exception.errors;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ErrorDetails {

    private String message ;

    private String errorCode ;
}

