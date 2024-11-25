package com.tarot.core.dto.member;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateMemberDto {
    private String username;
    private String email;
    private String password;

    @Builder
    public CreateMemberDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
