package com.whatever.ofi.service;

import com.whatever.ofi.domain.CoordinatorProfile;
import com.whatever.ofi.dto.CoordinatorProfileRequest;
import com.whatever.ofi.repository.CoordinatorProfileRepository;
import com.whatever.ofi.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoordinatorProfileService {

    private final CoordinatorProfileRepository coordinatorProfileRepository;
    private final CoordinatorRepository coordinatorRepository;

    @Transactional
    public void join(CoordinatorProfileRequest dto) {
        CoordinatorProfile profile = dto.toEntity();
        //연관관계 주입
        profile.setCoordinator(coordinatorRepository.findOne(dto.getCoordinator_id()));
        coordinatorProfileRepository.save(profile);
    }
}
