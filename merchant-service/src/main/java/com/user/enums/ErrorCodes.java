package com.user.enums;

import lombok.Getter;
import lombok.Setter;

public enum ErrorCodes {

    PRODUCT_EXP_001(400 , "Unable to save data into database");

    @Getter
    @Setter
    private int code ;

    @Getter
    @Setter
    private String message ;

    ErrorCodes(int code, String message)
    {
        this.code = code ;
        this.message = message ;
    }
}
