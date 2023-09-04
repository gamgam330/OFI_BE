package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString(exclude = "password")
@NoArgsConstructor
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
    private Board_like boardLike;

}
