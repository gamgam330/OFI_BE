package com.whatever.ofi.controller;

import com.whatever.ofi.domain.Member;
import com.whatever.ofi.dto.TestDto;
import com.whatever.ofi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@RequestBody Member member) {
        //memberService.join(member);
        System.out.println(member.toString());
        return "success";
    }

    @PostMapping("/page1")
    public String page1(@RequestBody TestDto dto, HttpSession session) {
        session.setAttribute("name", dto.getName());
        session.setAttribute("type", dto.getType());
        return dto.getName();
    }

    @PostMapping("/page2")
    public String page2(HttpSession session) {
        return session.getAttribute("name") + " " + session.getAttribute("type");
    }
}
