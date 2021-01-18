package com.example.demo.apps.club.config;

import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.club.service.ClubCrudService;
import com.example.demo.modules.crud.club.service.ClubMemberCrudService;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClubCrudConfig {

    private final ClubCrudRepository clubCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;
    private final MemberCrudRepository memberCrudRepository;
    private final CommunityCrudRepository communityCrudRepository;

    @Bean
    public ClubCrudService clubCrudService() {
        return new ClubCrudService(clubCrudRepository, clubMemberCrudRepository, memberCrudRepository, communityCrudRepository);
    }

    @Bean
    public ClubMemberCrudService clubMemberCrudService() {
        return new ClubMemberCrudService(clubCrudRepository, clubMemberCrudRepository, memberCrudRepository);
    }
}
