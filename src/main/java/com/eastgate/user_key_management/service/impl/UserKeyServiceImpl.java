package com.eastgate.user_key_management.service.impl;

import com.eastgate.user_key_management.dto.UserKeyDTO;
import com.eastgate.user_key_management.repository.UserKeyRepository;
import com.eastgate.user_key_management.service.UserKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Qualifier("defaultUserKeyService")
public class UserKeyServiceImpl implements UserKeyService {

    @Autowired
    private UserKeyRepository userKeyRepository;

    @Override
    public UserKeyDTO createUserKey(String username) {
        return null;
    }

    @Override
    public List<UserKeyDTO> findAllByUsernameOrderByCreatedDateAsc(String username) {
        return List.of();
    }
}
