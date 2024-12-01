package com.tarot.core.services;

import com.tarot.core.dto.service.member.CreateMemberDto;
import com.tarot.core.dto.service.member.UpdateMemberDto;
import com.tarot.core.entities.Member;

import java.util.List;
import java.util.UUID;

public interface MemberService {
    public void addMember(CreateMemberDto createUserDto);
    public void deleteMember(UUID uuid);
    public void updateMember(UUID uuid, UpdateMemberDto updateMemberDto);
    public Member getMember(UUID uuid);
    public Member getMemberMyEmail(String email);
    public Member authenticate(String email, String password);
    public List<Member> getAllMembers();
    public String issueToken();
}