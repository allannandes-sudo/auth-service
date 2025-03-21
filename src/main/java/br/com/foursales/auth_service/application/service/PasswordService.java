package br.com.foursales.auth_service.application.service;

public interface PasswordService {
    String encrypt(String rawPassword);
    boolean matches(String rawPassword, String hashedPassword);
}
