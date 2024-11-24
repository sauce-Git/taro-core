package com.taro.core.services;

import com.taro.core.dtos.CreateMemberDto;
import com.taro.core.dtos.UpdateMemberDto;

import java.util.UUID;

public interface MemberService {
    public void addMember(CreateMemberDto createUserDto);
    public void deleteMember(UUID uuid);
    public void updateMember(UUID uuid, UpdateMemberDto updateMemberDto);
    public void getMember();
    public void getAllMembers();
}