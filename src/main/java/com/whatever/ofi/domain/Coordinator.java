package com.whatever.ofi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString(exclude = "password")
@Getter @Setter
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coordinator_id")
    private Long id;

    private String email;

    private String nickname;

    private String password;

    private int height;

    private int weight;

    public void Coordinator(String email, String password, String nickname, int height, int weight) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
    }
}
