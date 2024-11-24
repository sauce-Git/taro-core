package com.taro.core.repositories;

import com.taro.core.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUuid(UUID uuid);
    void deleteByUuid(UUID uuid);
}
