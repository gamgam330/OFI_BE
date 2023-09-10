package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserStyle {
    @Id
    @Column(name = "user_id")
    private Long id;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    private String style;

    @Builder
    public UserStyle(String style) {
        this.style = style;
    }
}
