package com.example.demo.modules.crud.community.entitiys;

import com.example.demo.modules.crud.club.entitys.Club;
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

    @CreationTimestamp
    private LocalDateTime registDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "community", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> post = new ArrayList<>();

    @Builder
    public Community(Club club) {
        this.club = club;
    }
}
