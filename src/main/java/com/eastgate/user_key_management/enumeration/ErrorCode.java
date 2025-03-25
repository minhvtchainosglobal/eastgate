package com.eastgate.user_key_management.enumeration;

public enum ErrorCode {
    USERNAME_CANNOT_BE_EMPTY(1001, "Username cannot be empty"),
    USER_HAS_MAXIMUM_NUMBER_OF_KEY(1002, "User already has maximum number of keys (5)"),
    USER_KEY_IS_NOT_FOUND(1003, "User Key is not found"),
    USER_KEY_CANNOT_BE_EMPTY(1004, "User Key cannot be empty"),
    USER_KEY_HAS_WRONG_FORMAT(1005, "User Key has wrong format");

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
