package com.exemple.brista.entity.user;

public record LoginResponseDTO(String token, String login, UserRole role) { }
