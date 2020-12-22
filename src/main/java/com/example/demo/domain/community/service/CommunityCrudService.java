package com.example.demo.domain.community.service;

import com.example.demo.commons.errors.exception.ClubMemberNotFoundException;
import com.example.demo.commons.errors.exception.ClubNotFoundException;
import com.example.demo.commons.errors.exception.MemberNotFoundException;
import com.example.demo.domain.club.entitys.Club;
import com.example.demo.domain.club.entitys.ClubMember;
import com.example.demo.domain.club.repository.ClubCrudRepository;
import com.example.demo.domain.club.repository.ClubMemberCrudRepository;
import com.example.demo.domain.community.dtos.CommunitySaveDto;
import com.example.demo.domain.community.entitiys.Community;
import com.example.demo.domain.community.repository.CommunityCrudRepository;
import com.example.demo.domain.member.entitys.Member;
import com.example.demo.domain.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityCrudService {

    private final CommunityCrudRepository communityCrudRepository;
    private final ClubCrudRepository clubCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;
    private final MemberCrudRepository memberCrudRepository;

//    public Community save(CommunitySaveDto dto) {
//
//        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
//                dto.getClubName(),
//                dto.getClubCity(),
//                dto.getClubDistrict()
//        ).orElseThrow(ClubNotFoundException::new);
//
//        Member member = memberCrudRepository.findById(
//                dto.getMemberId()
//        ).orElseThrow(MemberNotFoundException::new);
//
//        ClubMember clubMember = clubMemberCrudRepository.findByClubAndMember(
//                club,
//                member
//        ).orElseThrow(ClubMemberNotFoundException::new);
//
//        return communityCrudRepository.save(
//                Community.builder()
//                .title(dto.getTitle())
//                .content(dto.getContent())
//                .like(dto.getLike())
//                .club(club)
//                .clubMember(clubMember)
//                .build()
//        );
//
//    }

}
