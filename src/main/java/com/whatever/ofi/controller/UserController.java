package com.whatever.ofi.controller;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import com.whatever.ofi.domain.User;
import com.whatever.ofi.repository.BoardLikeRepository;
import com.whatever.ofi.requestDto.*;
import com.whatever.ofi.responseDto.UserBoardLikeRes;
import com.whatever.ofi.responseDto.UserMyPageRes;
import com.whatever.ofi.service.BoardLikeService;
import com.whatever.ofi.service.BoardService;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    private final BoardLikeService boardLikeService;

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
    public String createProfile(@RequestBody UserInfoRequest dto, HttpSession session){
        session.setAttribute("nickname", dto.getNickname());
        session.setAttribute("gender", dto.getGender());
        session.setAttribute("height", dto.getHeight());
        session.setAttribute("weight", dto.getWeight());
        session.setAttribute("shape", dto.getShape());

        return "success";
    }

    @PostMapping("styles")
    public String addStyle(@RequestBody UserStyleRequest dto, HttpSession session) {
        User user = User.builder()
                .email((String) session.getAttribute("email"))
                .password((String) session.getAttribute("password"))
                .nickname((String) session.getAttribute("nickname"))
                .height((Integer) session.getAttribute("height"))
                .weight((Integer) session.getAttribute("weight"))
                .gender((Gender) session.getAttribute("gender"))
                .shape((Shape) session.getAttribute("shape"))
                .styles(dto.getStyles())
                .build();

        session.invalidate(); // 세션에 있는 속성 삭제
        userService.join(user);
        return "success";
    }

    @GetMapping("/mypage")
    public UserMyPageRes showMyPage(@RequestParam Long id) {
        return userService.findMyPage(id);
    }

    @GetMapping("/like")
    public String like(@RequestParam("userId") Long userId,
                       @RequestParam("boardId") Long boardId) {

        boardLikeService.increaseLike(userId, boardId);
        return "success";
    }

    @GetMapping("/unlike")
    public String unLike(@RequestParam("userId") Long userId,
                         @RequestParam("boardId") Long boardId) {
        return boardLikeService.decreaseLike(userId, boardId);
    }

    @GetMapping("/board/like")
    public List<UserBoardLikeRes> showLikeBoard(@RequestParam Long id) {
        return userService.findBoardLike(id);
    }

    @PostMapping("/edit")
    public String editProfile(@RequestBody UserEditRequest dto) {
        return userService.editProfile(dto);
    }
}
