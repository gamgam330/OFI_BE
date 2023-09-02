package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
public class Profile_cn {
    @Id
    @Column(name = "coordinator_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    private String image_url;

    private int total_like;

    private int request_count;
}
