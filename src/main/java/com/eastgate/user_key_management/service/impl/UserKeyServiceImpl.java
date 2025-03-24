package com.eastgate.user_key_management.service.impl;

import com.eastgate.user_key_management.dto.UserKeyDTO;
import com.eastgate.user_key_management.entity.UserKeyEntity;
import com.eastgate.user_key_management.enumeration.Constants;
import com.eastgate.user_key_management.enumeration.ErrorCode;
import com.eastgate.user_key_management.exception.BusinessException;
import com.eastgate.user_key_management.mapper.UserKeyMapper;
import com.eastgate.user_key_management.repository.UserKeyRepository;
import com.eastgate.user_key_management.service.UserKeyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Random;


@Service
@Qualifier("defaultUserKeyService")
@Slf4j
public class UserKeyServiceImpl implements UserKeyService {
    private static final Logger logger = LoggerFactory.getLogger(UserKeyServiceImpl.class);
    private final Random random = new Random();

    @Autowired
    private UserKeyRepository userKeyRepository;

    @Autowired
    private UserKeyMapper userKeyMapper;

    @Override
    public UserKeyDTO createUserKey(String username) {
        List<UserKeyDTO> userKeyDTOs = findAllByUsernameOrderByCreatedDateAsc(username);
        if (userKeyDTOs.size() >= 5) {
            logger.error("Reaching maximum number of keys for user {}", username);
            throw new BusinessException(ErrorCode.USER_HAS_MAXIMUM_NUMBER_OF_KEY);
        }
        String rawKey = username + Constants.HASH_SYMBOL + (random.nextInt(100) + 1);
        String encodedKey = Base64.getEncoder().encodeToString(rawKey.getBytes());

        UserKeyEntity userKeyEntity = new UserKeyEntity(username, encodedKey, System.currentTimeMillis());
        return userKeyMapper.toDto(userKeyRepository.save(userKeyEntity));
    }

    @Override
    public List<UserKeyDTO> findAllByUsernameOrderByCreatedDateAsc(String username) {
        return userKeyMapper.toDto(userKeyRepository.findAllByUsernameOrderByCreatedDateAsc(username));
    }
}
