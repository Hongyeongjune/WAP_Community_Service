package com.example.demo.modules.crud.community.service;

import com.example.demo.commons.errors.exception.*;
import com.example.demo.modules.crud.club.entitys.Club;
import com.example.demo.modules.crud.club.repository.ClubCrudRepository;
import com.example.demo.modules.crud.club.repository.ClubMemberCrudRepository;
import com.example.demo.modules.crud.community.dtos.PostDeleteDto;
import com.example.demo.modules.crud.community.dtos.PostLikeUpdateDto;
import com.example.demo.modules.crud.community.dtos.PostSaveDto;
import com.example.demo.modules.crud.community.dtos.PostUpdateDto;
import com.example.demo.modules.crud.community.entitiys.Community;
import com.example.demo.modules.crud.community.entitiys.Post;
import com.example.demo.modules.crud.community.repository.CommunityCrudRepository;
import com.example.demo.modules.crud.community.repository.PostCrudRepository;
import com.example.demo.modules.crud.member.entitys.Member;
import com.example.demo.modules.crud.member.repository.MemberCrudRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostCrudService {

    private final CommunityCrudRepository communityCrudRepository;
    private final ClubCrudRepository clubCrudRepository;
    private final MemberCrudRepository memberCrudRepository;
    private final PostCrudRepository postCrudRepository;
    private final ClubMemberCrudRepository clubMemberCrudRepository;

    /**
     * Apps Layer -> 성능 개선 예정
     *
     * 개선 해야 할 서비스 :
     *      JWT 토큰 사용 -> 인증 방식 간소화 및 보안 강화
     *      QueryDsl, JPQL, @Query 사용하여 데이터베이스 접근 최소화
     *      Post 게시물 페이징 처리
     */

    public Post save(PostSaveDto dto) {

        Member member = memberCrudRepository.findById(
                dto.getMemberId()
        ).orElseThrow(MemberNotFoundException::new);

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        clubMemberCrudRepository.findByClubAndMember(
                club,
                member
        ).orElseThrow(ClubMemberNotFoundException::new);

        Community community = communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

        return postCrudRepository.save(
                Post.builder()
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .community(community)
                        .member(member)
                        .build()
        );
    }

    public Post find(Long postId) {
        return postCrudRepository.findById(
                postId
        ).orElseThrow(PostNotFoundException::new);
    }

    public Post update(PostUpdateDto dto) {

        Member member = memberCrudRepository.findById(
                dto.getMemberId()
        ).orElseThrow(MemberNotFoundException::new);

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        clubMemberCrudRepository.findByClubAndMember(
                club,
                member
        ).orElseThrow(ClubMemberNotFoundException::new);

        communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

        Post post = postCrudRepository.findByPostIdAndMember(
                dto.getPostId(), member
        ).orElseThrow(PostNotFoundException::new);

        return postCrudRepository.save(
                post.update(
                        dto.getTitle(),
                        dto.getContent()
                )
        );
    }

    public Post updateLike(PostLikeUpdateDto dto) {

        Member member = memberCrudRepository.findById(
                dto.getMemberId()
        ).orElseThrow(MemberNotFoundException::new);

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        clubMemberCrudRepository.findByClubAndMember(
                club,
                member
        ).orElseThrow(ClubMemberNotFoundException::new);

        communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

        Post post = postCrudRepository.findById(
                dto.getPostId()
        ).orElseThrow(PostNotFoundException::new);

        return postCrudRepository.save(
                post.updateLike()
        );
    }

    public void delete(PostDeleteDto dto) {

        Member member = memberCrudRepository.findById(
                dto.getMemberId()
        ).orElseThrow(MemberNotFoundException::new);

        Club club = clubCrudRepository.findByClubNameAndCityAndDistrict(
                dto.getClubName(),
                dto.getClubCity(),
                dto.getClubDistrict()
        ).orElseThrow(ClubNotFoundException::new);

        clubMemberCrudRepository.findByClubAndMember(
                club,
                member
        ).orElseThrow(ClubMemberNotFoundException::new);

        communityCrudRepository.findByClub(
                club
        ).orElseThrow(CommunityNotFoundException::new);

        postCrudRepository.deleteByPostIdAndMember(dto.getPostId(), member);
    }

}
