package com.tarot.core.dto.service.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocalLoginDto {
    private String email;
    private String password;
}
