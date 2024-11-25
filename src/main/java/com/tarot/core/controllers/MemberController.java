package com.tarot.core.controllers;

import com.tarot.core.dto.member.CreateMemberDto;
import com.tarot.core.dto.member.LocalLoginDto;
import com.tarot.core.entities.Member;
import com.tarot.core.services.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/local/register")
    public ResponseEntity<Void> register(@RequestParam("username") final String username,
                                         @RequestParam("email") final String email,
                                         @RequestParam("password") final String password) {
        final CreateMemberDto createMemberDto = CreateMemberDto.builder()
                                                               .username(username)
                                                               .email(email)
                                                               .password(password)
                                                               .build();
        memberService.addMember(createMemberDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/local/issue-session")
    public ResponseEntity<Void> issueToken(
            @RequestParam("email") final String email,
            @RequestParam("password") final String password,
            final HttpServletRequest request) {
        final Member member = memberService.authenticate(email, password);
        if (member == null) {
            return ResponseEntity.badRequest().build();
        } else {
            final HttpSession session = request.getSession();
            session.setAttribute("memberId", member.getId());
            session.setMaxInactiveInterval(3600);
            return ResponseEntity.ok().build();
        }
    }
}
