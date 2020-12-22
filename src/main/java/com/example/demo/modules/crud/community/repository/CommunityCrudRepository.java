package com.example.demo.modules.crud.community.repository;

import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.community.entitiys.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunityCrudRepository extends JpaRepository<Community, Long> {
    Optional<Community> findByClub(Club club);
}
