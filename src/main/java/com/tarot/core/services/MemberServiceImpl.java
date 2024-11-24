package com.tarot.core.services;

import com.tarot.core.dtos.CreateMemberDto;
import com.tarot.core.dtos.UpdateMemberDto;
import com.tarot.core.entities.Member;
import com.tarot.core.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void addMember(CreateMemberDto createUserDto) {
        Member member = Member.builder()
                              .nickname(createUserDto.getUsername())
                              .email(createUserDto.getEmail())
                              .password(createUserDto.getPassword())
                              .build();
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(UUID uuid) {
        memberRepository.deleteByUuid(uuid);
    }

    @Override
    public void updateMember(UUID uuid, UpdateMemberDto updateMemberDto) {
        Member member = memberRepository.findByUuid(uuid);

        if (updateMemberDto.getUsername() != null) {
            member.setNickname(updateMemberDto.getUsername());
        }
        if (updateMemberDto.getEmail() != null) {
            member.setEmail(updateMemberDto.getEmail());
        }
        if (updateMemberDto.getPassword() != null) {
            member.setPassword(updateMemberDto.getPassword());
        }

        memberRepository.save(member);
    }

    @Override
    public void getMember() {
        System.out.println("Member retrieved");
    }

    @Override
    public void getAllMembers() {
        System.out.println("All members retrieved");
    }
}
