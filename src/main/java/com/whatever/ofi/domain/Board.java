package com.whatever.ofi.domain;

import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Board_img> urls = new ArrayList<>();

    private String style;
    private int like_count;
    private String season;
    private String situation;
    private String content;
    private String image_url;

    //==연관관계 메서드==//
    public void addUrl(Board_img boardImg) {
        urls.add(boardImg);
        boardImg.setBoard(this);
    }

    //==비지니스 로직==//
    public void addLike() {
        this.like_count += 1;
    }

    public void removeLike() {
        int resultLike = this.like_count - 1;

        if(resultLike < 0) {
            return;
        }

        this.like_count = resultLike;
    }
}
