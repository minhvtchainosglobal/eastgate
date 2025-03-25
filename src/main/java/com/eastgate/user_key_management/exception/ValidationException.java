package com.eastgate.user_key_management.exception;

import com.eastgate.user_key_management.enumeration.ErrorCode;
import lombok.Data;

@Data
public class ValidationException extends RuntimeException {
    private int errorCode;
    private String errorMessage;

    public ValidationException(String errorMessage, int errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getErrorCode();
    }

}
