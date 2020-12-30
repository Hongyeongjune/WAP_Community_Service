package com.example.demo.apps.member.service;

import com.example.demo.apps.member.dtos.MemberLoginReqDto;
import com.example.demo.apps.member.dtos.MemberSaveReqDto;
import com.example.demo.commons.enums.MemberRole;
import com.example.demo.commons.errors.exception.AccessDeniedAuthenticationException;
import com.example.demo.commons.errors.exception.MemberNotFoundException;
import com.example.demo.modules.crud.member.entitys.Member;
import com.example.demo.modules.crud.member.service.MemberCrudService;
import com.example.demo.modules.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberCrudService memberCrudService;

    public String login(MemberLoginReqDto dto) {
         Member member = memberCrudService.find(dto.getId());

         if(!passwordEncoder.matches(dto.getPassword(), member.getPassword()))
             throw new MemberNotFoundException();

         return jwtTokenProvider.createToken(member.getId(), member.getRoleSet());
    }

    public void signUp(String token, MemberSaveReqDto dto) {
        MemberRole role = Enum.valueOf(MemberRole.class, dto.getType().name());
        if (!jwtTokenProvider.hasRole(jwtTokenProvider.resolveToken(token), role))
            throw new AccessDeniedAuthenticationException();

        String encodedPw = passwordEncoder.encode(dto.getPassword());
        memberCrudService.save(dto.toMemberSaveDto(encodedPw));
    }

}
