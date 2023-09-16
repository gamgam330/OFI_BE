package com.whatever.ofi.domain;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(exclude = "password")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    private String email;

    private String password;

    private String nickname;

    private int height;

    private int weight;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Shape shape;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private BoardLike boardLike;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserStyle> userStyles = new ArrayList<>();

    //==연관관계 메서드==//
    public void addStyle(UserStyle userStyle) {
        userStyles.add(userStyle);
        userStyle.setUser(this);
    }

    @Builder
    public User(String email, String password, String nickname, int height, int weight,
                Gender gender, Shape shape) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.shape = shape;
    }
}
