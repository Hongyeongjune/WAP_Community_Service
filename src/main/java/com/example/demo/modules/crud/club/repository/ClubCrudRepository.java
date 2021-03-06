package com.example.demo.modules.crud.club.repository;

import com.example.demo.modules.crud.club.entitys.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubCrudRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByClubNameAndCityAndDistrict(String clubName, String city, String district);
    boolean existsByClubNameAndCityAndDistrict(String clubName, String city, String district);
}
