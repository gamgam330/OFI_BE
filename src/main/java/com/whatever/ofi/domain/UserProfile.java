package com.whatever.ofi.domain;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfile {
    @Id
    @Column(name = "user_id")
    private Long id;

    @MapsId
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    private String nickname;

    private int height;

    private int weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Shape shape;

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public UserProfile(String nickname, int height, int weight,
                       Gender gender, Shape shape) {
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.shape = shape;
    }
}
