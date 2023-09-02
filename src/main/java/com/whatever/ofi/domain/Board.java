package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    private String style;
    private int like_count;
    private String season;
    private String situation;
    private String content;
    private String image_url;

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
