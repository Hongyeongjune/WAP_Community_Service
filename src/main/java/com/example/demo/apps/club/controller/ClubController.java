package com.example.demo.apps.club.controller;

import com.example.demo.apps.club.dtos.ClubSaveReqDto;
import com.example.demo.apps.club.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping
    public void createClub(@RequestBody ClubSaveReqDto dto) {
        clubService.save(dto);
    }
}
