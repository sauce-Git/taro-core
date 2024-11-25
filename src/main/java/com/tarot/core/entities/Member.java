package com.tarot.core.entities;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "member", uniqueConstraints = {
        @UniqueConstraint(name = "email_unique", columnNames = "email"),
        @UniqueConstraint(name = "nickname_unique", columnNames = "nickname"),
        @UniqueConstraint(name = "uuid_unique", columnNames = "uuid")
})
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid", nullable = false, unique = true)
    @Nonnull
    private UUID uuid;
    @Column(name = "nickname", nullable = false, unique = true)
    @Nonnull
    private String nickname;
    @Column(name = "email", nullable = false, unique = true)
    @Nonnull
    private String email;
    @Column(name = "password", nullable = false)
    @Nonnull
    private String password;

    @Builder
    public Member(@Nullable Long id, @Nonnull String nickname, @Nonnull String email, @Nonnull String password) {
        this.id = id;
        this.uuid = UUID.randomUUID();
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
}
