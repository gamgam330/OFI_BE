package com.whatever.ofi.controller;

import com.whatever.ofi.domain.Coordinator;
import com.whatever.ofi.service.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coordinator")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    @PostMapping("/register")
    public String register(@RequestBody Coordinator coordinator) {
        System.out.println(coordinator.toString());
        return "success";
    }
}
