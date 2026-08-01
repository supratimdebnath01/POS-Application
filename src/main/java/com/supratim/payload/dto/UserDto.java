package com.supratim.payload.dto;

import com.supratim.domain.UsereRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private UsereRole role;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

}
