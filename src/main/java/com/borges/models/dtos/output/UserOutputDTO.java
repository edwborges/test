package com.borges.models.dtos.output;

import java.util.UUID;

public record UserOutputDTO(
        UUID id,
        String name,
        String email,
        Integer age) {
}
