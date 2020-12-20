package com.example.demo.domain.club.repository;

import com.example.demo.domain.club.entitys.Club;
import com.example.demo.domain.club.entitys.ClubMember;
import com.example.demo.domain.member.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubMemberCrudRepository extends JpaRepository<ClubMember, Long> {
    Optional<ClubMember> findByClubAndMember(Club club, Member member);
}
