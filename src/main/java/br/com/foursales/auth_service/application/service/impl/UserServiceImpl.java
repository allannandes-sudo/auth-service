package br.com.foursales.auth_service.application.service.impl;

import br.com.foursales.auth_service.application.dto.user.UserRequestDTO;
import br.com.foursales.auth_service.application.dto.user.UserResponseDTO;
import br.com.foursales.auth_service.application.service.PasswordService;
import br.com.foursales.auth_service.application.service.UserService;
import br.com.foursales.auth_service.domain.exception.UserAlreadyExistsException;
import br.com.foursales.auth_service.infrastructure.persistence.entity.UserEntity;
import br.com.foursales.auth_service.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Transactional
    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByUsername(userRequestDTO.getUsername())) {
            throw new UserAlreadyExistsException("Usuário já existe!");
        }

        UserEntity user = new UserEntity();
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword(passwordService.encrypt(userRequestDTO.getPassword()));

        // Se roles não for fornecido, definir como USER por padrão
        Set<String> roles = (userRequestDTO.getRoles() == null || userRequestDTO.getRoles().isEmpty())
                ? Collections.singleton("USER")
                : new HashSet<>(userRequestDTO.getRoles());

        user.setRoles(roles);

        userRepository.save(user);

        return new UserResponseDTO(user.getId(), user.getUsername(), user.getRoles());
    }
}
