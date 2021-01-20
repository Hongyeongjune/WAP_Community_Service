package com.example.demo.apps.community.controller;

import com.example.demo.apps.community.dtos.PostSaveReqDto;
import com.example.demo.apps.community.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

    private final PostService postService;

    @PostMapping(value = "/post")
    public void savePosts(@RequestBody PostSaveReqDto dto) {
        postService.save(dto);
    }
}
