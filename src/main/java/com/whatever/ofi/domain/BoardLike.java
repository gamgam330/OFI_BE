package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_like_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public BoardLike(Board board, User user) {
        this.board = board;
        this.user = user;
    }

    //==생성 메서드==//
    /*public static BoardLike createLike(Board board, User user) {
        BoardLike boardLike = new BoardLike(board, user);
        return boardLike;
    }*/
}
