package com.eastgate.user_key_management.mapper;

import com.eastgate.user_key_management.dto.UserKeyDTO;
import com.eastgate.user_key_management.entity.UserKeyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserKeyMapper extends EntityMapper<UserKeyDTO, UserKeyEntity> {
}
