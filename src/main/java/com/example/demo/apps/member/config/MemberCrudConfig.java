package com.example.demo.apps.member.config;

import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import com.example.demo.modules.crud.member.service.MemberCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberCrudConfig {

    private final MemberCrudRepository memberCrudRepository;

    @Bean
    public MemberCrudService memberCrudService() {
        return new MemberCrudService(memberCrudRepository);
    }
}
