package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString(exclude = "password")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String email;

    private String nickname;

    private String password;

    private int height;

    private int weight;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private BoardLike boardLike;

}
