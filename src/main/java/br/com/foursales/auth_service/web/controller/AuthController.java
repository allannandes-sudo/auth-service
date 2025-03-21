package br.com.foursales.auth_service.web.controller;

import br.com.foursales.auth_service.application.dto.auth.AuthRequestDTO;
import br.com.foursales.auth_service.application.dto.auth.AuthResponseDTO;
import br.com.foursales.auth_service.application.service.AuthService;
import br.com.foursales.auth_service.web.controller.swagger.AuthControllerDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerDoc {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        AuthResponseDTO response = authService.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
