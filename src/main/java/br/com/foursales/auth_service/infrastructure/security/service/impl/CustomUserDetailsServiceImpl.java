package br.com.foursales.auth_service.infrastructure.security.service.impl;


import br.com.foursales.auth_service.infrastructure.persistence.entity.UserEntity;
import br.com.foursales.auth_service.infrastructure.persistence.mapper.UserMapper;
import br.com.foursales.auth_service.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return userMapper.toUserDetails(userEntity);
    }
}

