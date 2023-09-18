package com.whatever.ofi.controller;

import com.whatever.ofi.requestDto.LoginRequest;
import com.whatever.ofi.service.CoordinatorService;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LoginController {
    private final UserService userService;

    private final CoordinatorService coordinatorService;

    @PostMapping("")
    public String login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);

        if(token == "Email Not Found" || token == "Password Not Equal") {
            System.out.println("Not user" + token + " " + loginRequest.getPassword());

            token = coordinatorService.login(loginRequest);

            if(token == "Email Not Found" || token == "Password Not Equal") {
                System.out.println("Not coor" + token + " " + loginRequest.getPassword());
                return token;
            }
        }

        Cookie cookie = new Cookie("token", token);

        cookie.setPath("/");
        cookie.setSecure(false);
        cookie.setMaxAge(86400); // 1일
        cookie.setHttpOnly(false);

        System.out.println(cookie.getValue());

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.addCookie(cookie);

        return "success";
    }
}
