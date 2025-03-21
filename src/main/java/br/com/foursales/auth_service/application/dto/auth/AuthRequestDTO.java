package br.com.foursales.auth_service.application.dto.auth;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String username;
    private String password;
}