package com.example.demo.apps.member.controller;

import com.example.demo.apps.member.dtos.MemberLoginReqDto;
import com.example.demo.apps.member.dtos.MemberSaveReqDto;
import com.example.demo.apps.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void signUpClient(@RequestBody MemberSaveReqDto dto) {
        memberService.signUp(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginReqDto dto) {
        return memberService.login(dto);
    }

}
