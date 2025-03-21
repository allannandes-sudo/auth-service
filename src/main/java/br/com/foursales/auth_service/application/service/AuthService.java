package br.com.foursales.auth_service.application.service;

import br.com.foursales.auth_service.application.dto.auth.AuthRequestDTO;
import br.com.foursales.auth_service.application.dto.auth.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO authenticate(AuthRequestDTO request);

    boolean validateToken(String token);

}
