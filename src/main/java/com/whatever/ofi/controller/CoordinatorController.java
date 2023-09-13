package com.whatever.ofi.controller;

import com.whatever.ofi.dto.CoordinatorProfileRequest;
import com.whatever.ofi.dto.CoordinatorRequest;
import com.whatever.ofi.dto.CoordinatorStyleRequest;
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
    public String register(@RequestBody CoordinatorRequest dto) {
        coordinatorService.join(dto);
        return "success";
    }

    @PostMapping("/profile")
    public String createProfile(@RequestBody CoordinatorProfileRequest dto) {

        System.out.println(dto.toString());
        coordinatorProfileService.join(dto);
        return "success";
    }

    @PostMapping("style")
    public String createStyle(@RequestBody CoordinatorStyleRequest dto) {

        return "success";
    }
}
