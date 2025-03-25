package com.eastgate.user_key_management.service;

import com.eastgate.user_key_management.dto.UserKeyDTO;

import java.util.List;

public interface UserKeyService {
    public UserKeyDTO createUserKey(String username);

    public List<UserKeyDTO> findAllByUsernameOrderByCreatedDateAsc(String username);

    public void deleteUserKey(String keyId);

}
