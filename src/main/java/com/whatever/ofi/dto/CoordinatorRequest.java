package com.whatever.ofi.dto;

import com.whatever.ofi.domain.Coordinator;
import lombok.Getter;

@Getter
public class CoordinatorRequest {
    private String email;

    private String password;

    public Coordinator toEntity() {
        return Coordinator.builder()
                .email(email)
                .password(password)
                .build();
    }
}
