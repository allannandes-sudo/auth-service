package br.com.foursales.auth_service.domain.exception;

import java.io.Serial;

public class UserAlreadyExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3030714032185708531L;

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
