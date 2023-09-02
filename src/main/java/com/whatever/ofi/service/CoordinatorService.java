package com.whatever.ofi.service;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    public void join(Coordinator coordinator) {
        coordinatorRepository.save(coordinator);
    }
}
