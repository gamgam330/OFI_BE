package com.whatever.ofi.controller;

import com.whatever.ofi.domain.Member;
import com.whatever.ofi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public String register(@RequestBody Member member) {
        memberService.join(member);
        System.out.println(member.toString());
        return "success";
    }
}
