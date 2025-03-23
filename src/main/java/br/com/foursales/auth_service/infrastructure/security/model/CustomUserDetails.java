package br.com.foursales.auth_service.infrastructure.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CustomUserDetails implements UserDetails {

    @Serial
    private static final long serialVersionUID = 8213363530634204342L;

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
