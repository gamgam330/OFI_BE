package com.whatever.ofi.controller;

import com.whatever.ofi.requestDto.CoordinatorProfileRequest;
import com.whatever.ofi.requestDto.CoordinatorRequest;
import com.whatever.ofi.requestDto.CoordinatorStyleRequest;
import com.whatever.ofi.service.CoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coordinator")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;

    private final BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody CoordinatorRequest dto, HttpSession session) {
        session.setAttribute("email", dto.getEmail());
        session.setAttribute("password", encoder.encode(dto.getPassword()));
        return "success";
    }

    @PostMapping("/profile")
    public String createProfile(@RequestBody CoordinatorProfileRequest dto) {
        coordinatorService.join(dto);
        return "success";
    }

//    @PostMapping("style")
//    public String createStyle(@RequestBody CoordinatorStyleRequest dto) {
//        coordinatorService.addStyle(dto);
//        return "success";
//    }
}
