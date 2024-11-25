package com.tarot.core.serviceImpls;

import com.tarot.core.dto.member.CreateMemberDto;
import com.tarot.core.dto.member.UpdateMemberDto;
import com.tarot.core.entities.Member;
import com.tarot.core.repositories.MemberRepository;
import com.tarot.core.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Member updatedMember = Member.builder()
                                     .id(member.getId())
                                     .nickname(
                                             updateMemberDto.getUsername() != null ? updateMemberDto.getUsername() : member.getNickname()
                                     )
                                     .email(
                                             updateMemberDto.getEmail() != null ? updateMemberDto.getEmail() : member.getEmail()
                                     )
                                     .password(
                                             updateMemberDto.getPassword() != null ? updateMemberDto.getPassword() : member.getPassword()
                                     )
                                     .build();

        memberRepository.save(updatedMember);
    }

    @Override
    public Member getMember(UUID uuid) {
        return memberRepository.findByUuid(uuid);
    }

    @Override
    public Member getMemberMyEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Member authenticate(String email, String password) {
        Member member = memberRepository.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public String issueToken() {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 18) {
            int index = (int) (Math.random() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        return salt.toString();
    }
}
