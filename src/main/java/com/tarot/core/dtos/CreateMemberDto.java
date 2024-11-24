package com.tarot.core.dtos;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateMemberDto {
    private String username;
    private String password;
    private String email;

    @Builder
    public CreateMemberDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
