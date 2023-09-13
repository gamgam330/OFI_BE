package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString(exclude = "password")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coordinator_id")
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<CoordinatorStyle> styles = new ArrayList<>();

    //==연관관계 메서드==//
    public void addBoard(Board board) {
        boards.add(board);
        board.setCoordinator(this);
    }

    public void addStyle(CoordinatorStyle coordinatorStyle) {
        styles.add(coordinatorStyle);
        coordinatorStyle.setCoordinator(this);
    }

    @Builder
    public Coordinator(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
