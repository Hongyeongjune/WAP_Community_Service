package com.example.demo.modules.crud.club.repository;

import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.club.entitys.ClubMember;
import com.example.demo.modules.crud.member.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubMemberCrudRepository extends JpaRepository<ClubMember, Long> {
    Optional<ClubMember> findByClubAndMember(Club club, Member member);
}
