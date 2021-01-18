package com.example.demo.modules.crud.club.service;

import com.example.demo.commons.enums.ClubMemberType;
import com.example.demo.commons.errors.exception.ClubAlreadyExistException;
import com.example.demo.commons.errors.exception.MemberNotFoundException;
import com.example.demo.modules.crud.club.dtos.ClubSaveDto;
import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.club.entitys.ClubMember;
import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.community.entitiys.Community;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.member.entitys.Member;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class ClubCrudService {

    private final ClubCrudRepository clubCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;
    private final MemberCrudRepository memberCrudRepository;
    private final CommunityCrudRepository communityCrudRepository;

    public Club save(ClubSaveDto dto) {
        if(clubCrudRepository.existsByClubNameAndCityAndDistrict(
                dto.getClubName(), dto.getClubCity(), dto.getClubDistrict()))
            throw new ClubAlreadyExistException();

        Member leader = memberCrudRepository.findById(dto.getLeader().getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        Club club = clubCrudRepository.save(Club.builder()
                .city(dto.getClubCity())
                .district(dto.getClubDistrict())
                .clubName(dto.getClubName())
                .build()
        );
        clubMemberCrudRepository.save(ClubMember.builder()
                .club(club)
                .member(leader)
                .clubMemberType(ClubMemberType.LEADER)
                .positionType(dto.getLeader().getPositionType())
                .uniformNum(dto.getLeader().getUniformNum())
                .build());

        communityCrudRepository.save(Community.builder().club(club).build());

        return club;
    }
}
