package com.whatever.ofi.controller;

import com.whatever.ofi.domain.User;
import com.whatever.ofi.dto.UserProfileRequest;
import com.whatever.ofi.dto.UserRequest;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest dto) {
        userService.join(dto);
        return "success";
    }

    @PostMapping("/profile")
    public String createProfile(@RequestBody UserProfileRequest dto){
        userService.addProfile(dto);
        return "success";
    }

//    @PostMapping("/page1")
//    public String page1(@RequestBody TestDto dto, HttpSession session) {
//        session.setAttribute("name", dto.getName());
//        session.setAttribute("type", dto.getType());
//        return dto.getName();
//    }
//
//    @PostMapping("/page2")
//    public String page2(HttpSession session) {
//        return session.getAttribute("name") + " " + session.getAttribute("type");
//    }
}
