package com.whatever.ofi.requestDto;

import lombok.Getter;

import java.util.List;

@Getter
public class CoordinatorStyleRequest {
    private Long coordinator_id;

    private List<String> styles;
}
