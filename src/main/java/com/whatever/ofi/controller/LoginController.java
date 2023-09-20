package com.whatever.ofi.controller;

import com.whatever.ofi.requestDto.LoginRequest;
import com.whatever.ofi.service.CoordinatorService;
import com.whatever.ofi.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class LoginController {
    private final UserService userService;

    private final CoordinatorService coordinatorService;

    @PostMapping("") // 여기서 사용자, 코디네이터 id 값 넘기기
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        String token = userService.login(loginRequest);
        String type;
        Long id;

        Cookie option;

        if(token == "Email Not Found" || token == "Password Not Equal") {
            System.out.println("Not user" + token + " " + loginRequest.getPassword());

            token = coordinatorService.login(loginRequest);

            if(token == "Email Not Found" || token == "Password Not Equal") {
                return token;
            }else {
                id = coordinatorService.findId(loginRequest.getEmail());
                type = "coordinator";
                option = new Cookie("type", "coordinator");
            }
        }else {
            id = userService.findId(loginRequest.getEmail());
            type = "user";
            option = new Cookie("type", "user");
        }

        Cookie cookie = new Cookie("token", token);

        cookie.setPath("/");
        cookie.setSecure(false);
        cookie.setMaxAge(86400); // 1일
        cookie.setHttpOnly(false);

        option.setPath("/");
        option.setSecure(false);
        option.setMaxAge(86400); // 1일
        option.setHttpOnly(false);


        System.out.println(cookie.getValue());

        session.setAttribute("id", id);
        session.setAttribute("type", type);

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.addCookie(cookie);
        response.addCookie(option);

        return "success";
    }

    @GetMapping("/test")
    public String test(HttpSession session) {

        String res = Long.toString((Long) session.getAttribute("id"));
        return res + ((String) session.getAttribute("type"));
    }
}
