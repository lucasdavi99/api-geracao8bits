package com.geracaooitobits.api.enums;

import lombok.Getter;

@Getter
public enum Role {
    USER("user"),
    ADMIN("admin");

    private String role;

    Role(String role){
        this.role = role;
    }
}
