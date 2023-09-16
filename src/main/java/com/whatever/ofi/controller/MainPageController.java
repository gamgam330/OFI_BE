package com.whatever.ofi.controller;

import com.whatever.ofi.domain.Board;
import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.repository.CoordinatorRepository;
import com.whatever.ofi.responseDto.UserMainPageRes;
import com.whatever.ofi.service.CoordinatorService;
import com.whatever.ofi.service.MainPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MainPageController {

    private final CoordinatorService coordinatorService;

    private final MainPageService mainPageService;

    @GetMapping("/user")
    public List<UserMainPageRes> showCoordinator() {
        return mainPageService.searchCoordinator();
    }

    @PostMapping("/test")
    public List<Board> testBoard() {
        return coordinatorService.testShow();
    }

    @GetMapping("test2")
    public Coordinator test2(@RequestParam Long id) {
        return coordinatorService.findOne(id);
    }
}
