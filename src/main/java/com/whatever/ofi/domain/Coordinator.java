package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString(exclude = "password")
@Getter @Setter
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coordinator_id")
    private Long id;

    private String email;

    private String nickname;

    private String password;

    private int height;

    private int weight;

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    public void Coordinator(String email, String password, String nickname, int height, int weight) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
    }

    //==연관관계 메서드==//
    public void addBoard(Board board) {
        boards.add(board);
        board.setCoordinator(this);
    }
}
