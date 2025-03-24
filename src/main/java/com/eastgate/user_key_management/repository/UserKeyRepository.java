package com.eastgate.user_key_management.repository;

import com.eastgate.user_key_management.entity.UserKeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserKeyRepository extends JpaRepository<UserKeyEntity, UUID> {

    List<UserKeyEntity> findAllByUsernameOrderByCreatedDateAsc(String username);
}
