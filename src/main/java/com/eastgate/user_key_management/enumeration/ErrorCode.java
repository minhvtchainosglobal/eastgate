package com.eastgate.user_key_management.enumeration;

public enum ErrorCode {
    USER_HAS_MAXIMUM_NUMBER_OF_KEY(1001, "User already has maximum number of keys (5)"),;

    private final int errorCode;
    private final String message;

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
