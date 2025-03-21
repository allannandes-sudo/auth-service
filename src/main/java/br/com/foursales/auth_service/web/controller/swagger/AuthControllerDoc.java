package br.com.foursales.auth_service.web.controller.swagger;

import br.com.foursales.auth_service.application.dto.auth.AuthRequestDTO;
import br.com.foursales.auth_service.application.dto.auth.AuthResponseDTO;
import br.com.foursales.auth_service.web.annotations.DefaultSwaggerMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Authenticate", description = "Endpoints para autenticação e autorização")
public interface AuthControllerDoc {

    @PostMapping("/login")
    @DefaultSwaggerMessage
    @Operation(summary = "Autentica um usuário e retorna um token JWT")
    ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request);
}
