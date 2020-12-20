package com.example.demo.domain.member.repository;

import com.example.demo.domain.member.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCrudRepository extends JpaRepository<Member, String> {
}
