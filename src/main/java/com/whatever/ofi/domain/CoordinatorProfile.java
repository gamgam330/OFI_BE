package com.whatever.ofi.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoordinatorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    private String nickname;

    private String sns_url;

    private String image_url;

    private String content;

    private int gender;

    private int height;

    private int weight;

    private int total_like;

    private int request_count;

    @Builder
    public CoordinatorProfile(String nickname, String sns_url, String image_url, String content,
                              int gender, int height, int weight, int total_like, int request_count){
        this.nickname = nickname;
        this.sns_url = sns_url;
        this.image_url = image_url;
        this.content = content;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.total_like = total_like;
        this.request_count = request_count;
    }
}
