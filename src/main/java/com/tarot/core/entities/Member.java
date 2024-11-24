package com.tarot.core.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "member", schema = "member", uniqueConstraints = {
        @UniqueConstraint(name = "email_unique", columnNames = "email"),
        @UniqueConstraint(name = "nickname_unique", columnNames = "nickname"),
        @UniqueConstraint(name = "uuid_unique", columnNames = "uuid")
})
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private UUID uuid;
    @Nonnull
    private String nickname;
    @Nonnull
    private String email;
    @Nonnull
    private String password;

    @Builder
    public Member(@Nonnull String nickname, @Nonnull String email, @Nonnull String password) {
        this.uuid = UUID.randomUUID();
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
