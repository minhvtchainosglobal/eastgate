package com.eastgate.user_key_management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserKeyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String username;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private long createdDate;

    public UserKeyEntity(String username, String code, long createdDate) {
        this.username = username;
        this.code = code;
        this.createdDate = createdDate;
    }
}
