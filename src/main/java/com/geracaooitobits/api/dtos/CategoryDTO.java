package com.geracaooitobits.api.dtos;

import jakarta.validation.constraints.NotNull;

public record CategoryDTO(@NotNull String name, String description) {
}
