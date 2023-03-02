package com.borges.models.dtos.input;

import java.util.UUID;

public record UserInputDTO(
        UUID id,
        String name,
        String email,
        String password,
        Integer age) {
}
