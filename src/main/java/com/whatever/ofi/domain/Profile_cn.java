package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class Profile_cn {
    @Id
    @Column(name = "coordinator_id")
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    private String nickname;

    private String sns_url;

    private String image_url;

    private String content;

    private int gender;

    private int height;

    private int weight;

    private int total_like;

    private int request_count;
}
