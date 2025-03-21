package br.com.foursales.auth_service.application.service;

import br.com.foursales.auth_service.application.dto.user.UserRequestDTO;
import br.com.foursales.auth_service.application.dto.user.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);
}
