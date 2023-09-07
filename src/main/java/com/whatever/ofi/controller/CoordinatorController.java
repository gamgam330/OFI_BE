package com.whatever.ofi.controller;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.dto.CdProfileRequest;
import com.whatever.ofi.service.CoordinatorProfileService;
import com.whatever.ofi.service.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coordinator")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;
    private final CoordinatorProfileService coordinatorProfileService;

    @PostMapping("/register")
    public String register(@RequestBody Coordinator coordinator) {
        coordinatorService.join(coordinator);
        return "success";
    }

    @PostMapping("/profile")
    public String createProfile(@RequestBody CdProfileRequest dto) {

        System.out.println(dto.toString());
        coordinatorProfileService.join(dto);
        return "success";
    }

    @GetMapping("/check/nickname")
    public String checkNickname(@RequestParam String nickname) {
        return "success";
    }
}
