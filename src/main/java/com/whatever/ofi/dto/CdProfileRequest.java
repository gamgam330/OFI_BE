package com.whatever.ofi.dto;

import com.whatever.ofi.domain.CoordinatorProfile;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CdProfileRequest {
    private String nickname;

    private String sns_url;

    private String image_url;

    private String content;

    private int gender;

    private int height;

    private int weight;

    private int total_like;

    private int request_count;

    public CoordinatorProfile toEntity() {
        return CoordinatorProfile.builder()
                .nickname(nickname)
                .sns_url(sns_url)
                .image_url(image_url)
                .content(content)
                .gender(gender)
                .height(height)
                .weight(weight)
                .total_like(total_like)
                .request_count(request_count)
                .build();
    }
}
