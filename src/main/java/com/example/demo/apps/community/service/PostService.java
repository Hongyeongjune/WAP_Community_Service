package com.example.demo.apps.community.service;

import com.example.demo.apps.community.dtos.PostSaveReqDto;
import com.example.demo.modules.crud.community.service.PostCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostCrudService postCrudService;

    public void save(PostSaveReqDto dto) {
        postCrudService.save(dto.toPostSaveDto());
    }

}
