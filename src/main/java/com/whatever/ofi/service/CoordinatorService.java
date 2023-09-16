package com.whatever.ofi.service;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.requestDto.CoordinatorProfileRequest;
import com.whatever.ofi.requestDto.CoordinatorRequest;
import com.whatever.ofi.requestDto.CoordinatorStyleRequest;
import com.whatever.ofi.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    @Transactional
    public void join(CoordinatorProfileRequest dto) {
        coordinatorRepository.save(dto.toEntity());
    }

    public Coordinator findOne(Long id) {
        return coordinatorRepository.findOne(id);
    }
//    @Transactional
//    public void addStyle(CoordinatorStyleRequest dto) {
//        Coordinator coordinator = coordinatorRepository.findOne(dto.getCoordinator_id());
//
//        for(String style : dto.getStyles()) {
//            CoordinatorStyle coordinatorStyle = new CoordinatorStyle(style);
//            coordinator.addStyle(coordinatorStyle);
//
//            coordinatorRepository.saveStyle(coordinatorStyle);
//        }
//    }

    public List<Board> testShow() {
        return coordinatorRepository.findMainPage();
    }
}
