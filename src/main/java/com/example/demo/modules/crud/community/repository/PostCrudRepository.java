package com.example.demo.modules.crud.community.repository;

import com.example.demo.modules.crud.community.entitiys.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCrudRepository extends JpaRepository<Post, Long> {
}
