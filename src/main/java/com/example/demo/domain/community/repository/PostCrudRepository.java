package com.example.demo.domain.community.repository;

import com.example.demo.domain.community.entitiys.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCrudRepository extends JpaRepository<Post, Long> {
}
