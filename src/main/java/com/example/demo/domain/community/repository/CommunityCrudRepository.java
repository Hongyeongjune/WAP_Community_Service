package com.example.demo.domain.community.repository;

import com.example.demo.domain.club.entitys.Club;
import com.example.demo.domain.club.entitys.ClubMember;
import com.example.demo.domain.community.entitiys.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunityCrudRepository extends JpaRepository<Community, Long> {
    Optional<Community> findByClubAndClubMember(Club club, ClubMember clubMember);
}
