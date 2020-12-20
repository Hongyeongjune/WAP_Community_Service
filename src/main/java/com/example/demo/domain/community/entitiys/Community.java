package com.example.demo.domain.community.entitiys;

import com.example.demo.domain.club.entitys.Club;
import com.example.demo.domain.club.entitys.ClubMember;
import com.example.demo.domain.member.entitys.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "community_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long communityId;

    private String title;

    private String content;

    private int like;

    @CreationTimestamp
    private LocalDateTime registDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(targetEntity = ClubMember.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "club_member_id")
    private ClubMember clubMember;

    @Builder

    public Community(String title, String content, int like, Club club, ClubMember clubMember) {
        this.title = title;
        this.content = content;
        this.like = like;
        this.club = club;
        this.clubMember = clubMember;
    }
}
