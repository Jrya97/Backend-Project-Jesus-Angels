package com.projectjesusangels.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
