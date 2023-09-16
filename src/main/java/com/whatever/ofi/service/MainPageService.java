package com.whatever.ofi.service;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.repository.CoordinatorRepository;
import com.whatever.ofi.responseDto.UserMainPageRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainPageService {
    private final CoordinatorRepository coordinatorRepository;

    public List<UserMainPageRes> searchCoordinator() {

        List<UserMainPageRes> profiles = coordinatorRepository.findPopularCoordinator();

        return profiles;
    }
}
