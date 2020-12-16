package com.example.demo.domain.club.entitys;

import com.example.demo.commons.enums.ClubMemberType;
import com.example.demo.commons.enums.PositionType;
import com.example.demo.domain.member.entitys.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "club_member_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreationTimestamp
    private LocalDateTime registDate;

    private int uniformNum;

    @Enumerated(value = EnumType.STRING)
    private PositionType positionType;

    @Enumerated(value = EnumType.STRING)
    private ClubMemberType clubMemberType;
}
