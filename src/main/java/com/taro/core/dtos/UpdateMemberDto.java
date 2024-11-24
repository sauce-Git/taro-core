package com.taro.core.dtos;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;

@Data
public class UpdateMemberDto {
    @Nullable
    private String username;
    @Nullable
    private String email;
    @Nullable
    private String password;

    @Builder
    public UpdateMemberDto(@Nullable String username, @Nullable String email, @Nullable String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
