package com.eastgate.user_key_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserKeyDTO {
    private UUID id;
    private String username;
    private String code;
    private long createdDate;
}
