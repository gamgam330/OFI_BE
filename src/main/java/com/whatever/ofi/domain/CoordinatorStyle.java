package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoordinatorStyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinator_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Coordinator coordinator;

    private String style;

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public CoordinatorStyle(String style) {
        this.style = style;
    }
}
