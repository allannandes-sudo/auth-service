package br.com.foursales.auth_service.web.controller;

import br.com.foursales.auth_service.application.dto.user.UserRequestDTO;
import br.com.foursales.auth_service.application.dto.user.UserResponseDTO;
import br.com.foursales.auth_service.application.service.UserService;
import br.com.foursales.auth_service.web.controller.swagger.UserControllerDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDoc {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO request) {
        UserResponseDTO userResponse = userService.registerUser(request);
        return ResponseEntity.ok(userResponse);
    }

}
