package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.kafka.common.protocol.types.Field;

import javax.persistence.*;

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
public class Board_img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_img_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Board board;

    private String img_url;
}
