package com.example.demo.modules.crud.community.repository;

import com.example.demo.modules.crud.community.entitiys.Post;
import com.example.demo.modules.crud.member.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostCrudRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByPostIdAndMember(Long postId, Member member);
    void deleteByPostIdAndMember(Long postId, Member member);
}
