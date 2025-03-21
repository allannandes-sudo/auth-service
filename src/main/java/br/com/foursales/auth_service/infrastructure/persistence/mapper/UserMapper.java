package br.com.foursales.auth_service.infrastructure.persistence.mapper;

import br.com.foursales.auth_service.domain.model.User;
import br.com.foursales.auth_service.infrastructure.persistence.entity.UserEntity;
import br.com.foursales.auth_service.infrastructure.security.model.CustomUserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {


    User toDomainUser(UserEntity entity);

    @Mapping(target = "authorities", source = "roles", qualifiedByName = "mapRolesToAuthorities")
    CustomUserDetails toUserDetails(UserEntity userEntity);

    @Named("mapRolesToAuthorities")
    default Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}