package com.example.demo.modules.crud.member.repository;

import com.example.demo.modules.crud.member.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCrudRepository extends JpaRepository<Member, String> {
}
