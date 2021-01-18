package com.example.demo.apps.club.service;

import com.example.demo.apps.club.dtos.ClubSaveReqDto;
import com.example.demo.modules.crud.club.service.ClubCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubCrudService clubCrudService;

    public void save(ClubSaveReqDto dto) {
        clubCrudService.save(dto.toClubSaveDto());
    }
}
