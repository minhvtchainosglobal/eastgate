package com.eastgate.user_key_management.exception;

import com.eastgate.user_key_management.dto.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<BaseResponseDTO> handleBusinessException(BusinessException exception) {
        BaseResponseDTO response = new BaseResponseDTO(String.valueOf(exception.getErrorCode()), exception.getMessage(),null);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<BaseResponseDTO> handleValidationException(ValidationException exception) {
        BaseResponseDTO response = new BaseResponseDTO(String.valueOf(exception.getErrorCode()), exception.getMessage(),null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
