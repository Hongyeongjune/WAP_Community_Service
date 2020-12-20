package com.example.demo.domain.community.repository;

import com.example.demo.domain.community.entitiys.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityCrudRepository extends JpaRepository<Community, Long> {


}
