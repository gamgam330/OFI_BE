package com.whatever.ofi.requestDto;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import com.whatever.ofi.domain.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserProfileRequest {
    private String email;

    private String password;

    private String nickname;

    private int height;

    private int weight;

    private Gender gender;

    private Shape shape;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .gender(gender)
                .height(height)
                .weight(weight)
                .nickname(nickname)
                .shape(shape)
                .build();
    }
}
