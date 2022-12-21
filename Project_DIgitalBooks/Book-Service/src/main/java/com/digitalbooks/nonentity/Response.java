package com.digitalbooks.nonentity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Response {

    private int status ;

    private String message ;
}
