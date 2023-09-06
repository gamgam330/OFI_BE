package com.whatever.ofi.service;

import com.whatever.ofi.domain.CoordinatorProfile;
import com.whatever.ofi.dto.CdProfileRequest;
import com.whatever.ofi.repository.CoordinatorProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoordinatorProfileService {

    private final CoordinatorProfileRepository coordinatorProfileRepository;

    @Transactional
    public void join(CdProfileRequest dto) {
        coordinatorProfileRepository.save(dto.toEntity());
    }
}
