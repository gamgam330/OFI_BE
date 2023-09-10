package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

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

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
