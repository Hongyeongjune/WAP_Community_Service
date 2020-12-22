package com.example.demo.modules.crud.community.service;

import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
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
