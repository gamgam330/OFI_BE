package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
public class Board_like {
    @Id
    @Column(name = "board_like_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "board_like_id")
    private Board board;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
