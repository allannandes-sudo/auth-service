package br.com.foursales.auth_service.web.controller.swagger;

import br.com.foursales.auth_service.application.dto.user.UserRequestDTO;
import br.com.foursales.auth_service.application.dto.user.UserResponseDTO;
import br.com.foursales.auth_service.web.annotations.DefaultSwaggerMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Register", description = "Endpoints criar usuario.")
public interface UserControllerDoc {

    @PostMapping("/register")
    @DefaultSwaggerMessage
    @Operation(summary = "Cria um usuário")
    ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request);
}
