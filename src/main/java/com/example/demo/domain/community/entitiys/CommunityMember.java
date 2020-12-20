package com.example.demo.domain.community.entitiys;

import com.example.demo.commons.enums.CommunityMemberType;
import com.example.demo.domain.member.entitys.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "community_member_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommunityMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    private Member member;

    @CreationTimestamp
    private LocalDateTime registDate;

    @Enumerated(value = EnumType.STRING)
    private CommunityMemberType communityMemberType;
}
