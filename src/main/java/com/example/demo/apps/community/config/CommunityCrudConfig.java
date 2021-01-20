package com.example.demo.apps.community.config;

import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.community.repository.PostCrudRepository;
import com.example.demo.modules.crud.community.service.CommunityCrudService;
import com.example.demo.modules.crud.community.service.PostCrudService;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommunityCrudConfig {

    private final CommunityCrudRepository communityCrudRepository;
    private final ClubCrudRepository clubCrudRepository;
    private final MemberCrudRepository memberCrudRepository;
    private final PostCrudRepository postCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;
    @Bean
    public CommunityCrudService communityCrudService() {
        return new CommunityCrudService(communityCrudRepository, clubCrudRepository);
    }

    @Bean
    public PostCrudService postCrudService() {
        return new PostCrudService(communityCrudRepository, clubCrudRepository, memberCrudRepository, postCrudRepository, clubMemberCrudRepository);
    }

}
