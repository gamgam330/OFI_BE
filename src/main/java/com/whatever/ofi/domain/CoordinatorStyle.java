package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoordinatorStyle {
    @Id
    @Column(name = "coordinator_id")
    private Long id;

    @MapsId
    @JoinColumn(name = "coordinator_id")
    @OneToOne
    private Coordinator coordinator;

    private String style;

    @Builder
    public CoordinatorStyle(String style) {
        this.style = style;
    }
}
