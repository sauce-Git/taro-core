package com.tarot.core.dto.service.member;

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
}
