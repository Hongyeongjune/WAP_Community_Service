package com.example.demo.modules.crud.club.service;

import com.example.demo.commons.errors.exception.ClubNotFoundException;
import com.example.demo.commons.errors.exception.MemberNotFoundException;
import com.example.demo.modules.crud.club.dtos.ClubMemberSaveDto;
import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.club.entitys.ClubMember;
import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.member.entitys.Member;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class ClubMemberCrudService {

    private final ClubCrudRepository clubCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;
    private final MemberCrudRepository memberCrudRepository;

    public ClubMember save(ClubMemberSaveDto dto) {
        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(), dto.getClubCity(), dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        Member member = memberCrudRepository.findById(dto.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        return clubMemberCrudRepository.save(
                ClubMember.builder()
                        .club(club)
                        .member(member)
                        .uniformNum(dto.getUniformNum())
                        .positionType(dto.getPositionType())
                        .clubMemberType(dto.getClubMemberType())
                        .build());
    }
}
