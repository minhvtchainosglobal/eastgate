package com.eastgate.user_key_management.controller;

import com.eastgate.user_key_management.dto.BaseResponseDTO;
import com.eastgate.user_key_management.dto.UserKeyDTO;
import com.eastgate.user_key_management.enumeration.Constants;
import com.eastgate.user_key_management.enumeration.ErrorCode;
import com.eastgate.user_key_management.exception.ValidationException;
import com.eastgate.user_key_management.service.UserKeyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/keys")
public class UserKeyController {

    @Autowired
    @Qualifier("defaultUserKeyService")
    private UserKeyService userKeyService;

    @PostMapping("/create/{username}")
    public ResponseEntity<BaseResponseDTO> createUserKey(@PathVariable String username) {
        if (StringUtils.isBlank(username)) {
            throw new ValidationException(ErrorCode.USERNAME_CANNOT_BE_EMPTY);
        }
        UserKeyDTO dto = userKeyService.createUserKey(username);
        return ResponseEntity.ok(BaseResponseDTO.builder().data(dto).build());
    }

    @GetMapping("/{username}")
    public ResponseEntity<BaseResponseDTO> getUserKey(@PathVariable String username) {
        if (StringUtils.isBlank(username)) {
            throw new ValidationException(ErrorCode.USERNAME_CANNOT_BE_EMPTY);
        }
        List<UserKeyDTO> data = userKeyService.findAllByUsernameOrderByCreatedDateAsc(username);
        BaseResponseDTO responseDTO = new BaseResponseDTO();
        responseDTO.setData(data);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{keyId}")
    public ResponseEntity<BaseResponseDTO> deleteUserKey(@PathVariable String keyId) {
        if (StringUtils.isBlank(keyId)) {
            throw new ValidationException(ErrorCode.USER_KEY_CANNOT_BE_EMPTY);
        }
        userKeyService.deleteUserKey(keyId);
        return ResponseEntity.ok(BaseResponseDTO.builder().data(Constants.SUCCESS).build());
    }
}
