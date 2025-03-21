package br.com.foursales.auth_service.application.service.impl;

import br.com.foursales.auth_service.application.dto.auth.AuthRequestDTO;
import br.com.foursales.auth_service.application.dto.auth.AuthResponseDTO;
import br.com.foursales.auth_service.application.service.AuthService;
import br.com.foursales.auth_service.domain.model.User;
import br.com.foursales.auth_service.infrastructure.persistence.entity.UserEntity;
import br.com.foursales.auth_service.infrastructure.persistence.mapper.UserMapper;
import br.com.foursales.auth_service.infrastructure.persistence.repository.UserRepository;
import br.com.foursales.auth_service.infrastructure.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;

    @Override
    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        // Buscar usuário no banco
        UserEntity userEntity = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Converter UserEntity para User
        User user = userMapper.toDomainUser(userEntity);

        // Verificar senha
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Senha inválida");
        }

        // Converter Set<String> roles para String separada por vírgula
        String rolesString = String.join(",", user.getRoles());

        // Gerar token JWT com username e roles
        String token = jwtTokenProvider.generateToken(user.getUsername(), rolesString);

        return new AuthResponseDTO(token);
    }

    @Override
    public boolean validateToken(String token) {
        String username = jwtTokenProvider.extractUsername(token);

        // Buscar usuário no banco
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Converter UserEntity para UserDetails (ou User, se preferir)
        UserDetails userDetails = userMapper.toUserDetails(userEntity);

        return jwtTokenProvider.validateToken(token, userDetails);
    }

}
