package com.whatever.ofi.dto;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import com.whatever.ofi.domain.UserProfile;
import lombok.Getter;

@Getter
public class UserProfileRequest {
    private Long user_id;

    private String nickname;

    private int height;

    private int weight;

    private Gender gender;

    private Shape shape;

    public UserProfile toEntity() {
        return UserProfile.builder()
                .gender(gender)
                .height(height)
                .weight(weight)
                .nickname(nickname)
                .shape(shape)
                .build();
    }
}
