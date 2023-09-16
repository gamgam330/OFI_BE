package com.whatever.ofi.requestDto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserStyleRequest {
    private Long user_id;

    private List<String> styles;
}
