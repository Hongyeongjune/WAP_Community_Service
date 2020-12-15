package com.example.demo.domain.member.entitys;

import com.example.demo.commons.enums.DisclosureScopeState;
import com.example.demo.commons.enums.MemberRole;
import com.example.demo.commons.enums.PositionType;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @EqualsAndHashCode(of = "id")
 * => Equals() : 두 객체의 내용이 같은지, 동등성을 비교하는 연산자
 * => HashCode() : 두 객체가 같은 객체인지, 동일성을 비교하는 연산자
 * => of 속성을 사용하여 명시적으로 특정 필드를 포함하게 한다.
 * Reference Type 인 객체에 필드가 있고, 그 필드들을 인스턴스화 시켰을 때, 값이 같다고 같은 객체가 아니다.
 * Equals()로 같은 객체인지 확인을 해 주어야하는데, HashCode가 같은지 보고 판단한다.
 * of 속성을 명시하면 그 필드를 기준으로 동등성을 검사할 수 있다.
 * Set<객체> 를 사용해도 리스트 처럼 중복이 될 수 있다.
 */
@Getter
@Entity(name = "member_tbl")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;

    @NotNull
    private String password;

    @NotNull
    private String name;

    private String city;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    private int likeCnt;

    private int rudeCnt;

    private String pictureUri;

    /**
     * @ElementCollection(fetch = FetchType.EAGER)
     * RDBMS에는 내부적으로 Collection 객체를 담을 수 있는 구조가 없다.
     * Collection 객체는 1:N 의 개념이기 때문에 DataBase는 Collection을 하나의 테이블에 저장할 수 없다.
     * 이런 관계를 DataBase 테이블에 저장하려면 별도의 테이블이 필요하다.
     * FetchType (EAGER, LAZY)
     * EAGER => 즉시로딩 전략
     * LAZY => 지연로딩 전략
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<MemberRole> roleSet;

    @Enumerated(value = EnumType.STRING)
    private PositionType positionType;

    @Enumerated(value = EnumType.STRING)
    private DisclosureScopeState disclosureScopeState;
}
