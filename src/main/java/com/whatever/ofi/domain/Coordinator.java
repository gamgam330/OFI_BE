package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString(exclude = "password")
@Getter @Setter
@NoArgsConstructor
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coordinator_id")
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    //==연관관계 메서드==//
    public void addBoard(Board board) {
        boards.add(board);
        board.setCoordinator(this);
    }
}
