package com.geracaooitobits.api.dtos;

import com.geracaooitobits.api.enums.Role;

public record RegisterDTO(String email, String password, Role role, String name, String phone) {
}
