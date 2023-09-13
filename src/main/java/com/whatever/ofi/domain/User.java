package com.whatever.ofi.domain;

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
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
