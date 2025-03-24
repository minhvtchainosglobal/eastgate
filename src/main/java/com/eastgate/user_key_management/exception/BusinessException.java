package com.eastgate.user_key_management.exception;

import com.eastgate.user_key_management.enumeration.ErrorCode;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private int errorCode;
    private String errorMessage;

    public BusinessException(String errorMessage, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        this.errorMessage = errorCode.getMessage();
        this.errorCode = errorCode.getErrorCode();
    }

}
