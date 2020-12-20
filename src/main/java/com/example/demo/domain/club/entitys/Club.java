package com.example.demo.domain.club.entitys;

import com.example.demo.domain.community.entitiys.Community;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "club_tbl")
@EqualsAndHashCode(of = "clubId")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clubId;

    @NotNull
    private String clubName;

    @CreationTimestamp
    private LocalDateTime createDate;

    private String city;

    private String district;

    private String logoUri;

    private int likeCnt;

    private int rudeCnt;

    private int point;

    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ClubMember> clubMembers = new ArrayList<>();

    @OneToMany(mappedBy = "community", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Community> community = new ArrayList<>();

    @Builder
    public Club(String clubName, String city, String district, String logoUri) {
        this.clubName = clubName;
        this.city = city;
        this.district = district;
        this.logoUri = logoUri;
        this.likeCnt = 0;
        this.rudeCnt = 0;
        this.point = 0;
    }

}
