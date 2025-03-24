package com.eastgate.user_key_management.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponseDTO<T> {
    private String errorCode;
    private String errorMessage;
    private T data;
}
