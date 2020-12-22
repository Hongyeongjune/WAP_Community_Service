package com.example.demo.modules.crud.community.entitiys;

import com.example.demo.modules.crud.member.entitys.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity(name = "post_tbl")
@EqualsAndHashCode(of = "postId")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private String title;
    private String content;
    private int like;

    @CreationTimestamp
    private LocalDateTime registDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String content, Community community, Member member) {
        this.title = title;
        this.content = content;
        this.like = 0;
        this.community = community;
        this.member = member;
    }

    public Post update(String title, String content) {
        this.title = title;
        this.content = content;

        return this;
    }

    public Post updateLike() {
        this.like += 1;

        return this;
    }
}
