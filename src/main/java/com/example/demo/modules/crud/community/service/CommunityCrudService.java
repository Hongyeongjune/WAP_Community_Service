package com.example.demo.modules.crud.community.service;

import com.example.demo.commons.errors.exception.ClubNotFoundException;
import com.example.demo.commons.errors.exception.CommunityNotFoundException;
import com.example.demo.commons.errors.exception.MemberNotFoundException;
import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.community.dtos.CommunityFindDto;
import com.example.demo.modules.crud.community.dtos.CommunitySaveDto;
import com.example.demo.modules.crud.community.entitiys.Community;
import com.example.demo.modules.crud.community.entitiys.Post;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.member.entitys.Member;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
public class CommunityCrudService {

    private final CommunityCrudRepository communityCrudRepository;
    private final ClubCrudRepository clubCrudRepository;

    /**
     * Apps Layer -> 성능 개선 예정
     *
     * 개선 해야 할 서비스 :
     *      JWT 토큰 사용 -> 인증 방식 간소화 및 보안 강화
     *      QueryDsl, JPQL, @Query 사용하여 데이터베이스 접근 최소화
     *      Post 게시물 페이징 처리
     */
    public Community save(CommunitySaveDto dto) {

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        return communityCrudRepository.save(
                Community.builder()
                        .club(club)
                        .build()
        );
    }

    public Community find(CommunityFindDto dto) {

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        return communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

    }

    public void delete(CommunityFindDto dto) {
        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        Community community = communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

        communityCrudRepository.delete(community);
    }

}
