package com.whatever.ofi.controller;

import com.whatever.ofi.requestDto.LoginRequest;
import com.whatever.ofi.requestDto.UserProfileRequest;
import com.whatever.ofi.requestDto.UserRequest;
import com.whatever.ofi.requestDto.UserStyleRequest;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    private final BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest dto, HttpSession session) {
        String encodePassword = encoder.encode(dto.getPassword());

        session.setAttribute("email", dto.getEmail());
        session.setAttribute("password", encodePassword);
        System.out.println(encodePassword);
        return "success";
    }

    @PostMapping("/profile")
    public String createProfile(@RequestBody UserProfileRequest dto, HttpSession session){
        dto.setEmail((String) session.getAttribute("email"));
        dto.setPassword((String) session.getAttribute("password"));
        userService.join(dto);
        return "success";
    }

//    @GetMapping("/mypage")
//    public

//    @PostMapping("login")
//    public String login (@RequestBody LoginRequest loginRequest) {
//        String token = userService.login(loginRequest);
//
//        Cookie cookie = new Cookie("token", token);
//
//        cookie.setPath("/");
//        cookie.setSecure(false);
//        cookie.setMaxAge(86400); // 1일
//        cookie.setHttpOnly(false);
//
//        System.out.println(cookie.getValue());
//
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        response.addCookie(cookie);
//
//        return "success";
//    }
}
