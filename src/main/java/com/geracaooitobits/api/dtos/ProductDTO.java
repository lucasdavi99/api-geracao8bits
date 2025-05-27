package com.geracaooitobits.api.dtos;

import com.geracaooitobits.api.entities.Category;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(@NotNull String name, @NotNull String description, @NotNull BigDecimal price, @NotNull Integer stockQuantity, String imageUrl, String category) {
}
