package com.whatever.ofi.service;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.domain.CoordinatorStyle;
import com.whatever.ofi.dto.CoordinatorRequest;
import com.whatever.ofi.dto.CoordinatorStyleRequest;
import com.whatever.ofi.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    @Transactional
    public void join(CoordinatorRequest dto) {
        coordinatorRepository.save(dto.toEntity());
    }

    @Transactional
    public void addStyle(CoordinatorStyleRequest dto) {
        Coordinator coordinator = coordinatorRepository.findOne(dto.getCoordinator_id());

        for(String style : dto.getStyles()) {
            CoordinatorStyle coordinatorStyle = new CoordinatorStyle(style);
            coordinator.addStyle(coordinatorStyle);

            coordinatorRepository.saveStyle(coordinatorStyle);
        }
    }
}
