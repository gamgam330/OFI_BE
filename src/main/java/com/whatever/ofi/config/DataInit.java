package com.whatever.ofi.config;

import com.whatever.ofi.Enum.Gender;
import com.whatever.ofi.Enum.Shape;
import com.whatever.ofi.requestDto.BoardRequest;
import com.whatever.ofi.requestDto.CoordinatorProfileRequest;
import com.whatever.ofi.requestDto.UserProfileRequest;
import com.whatever.ofi.service.BoardService;
import com.whatever.ofi.service.CoordinatorService;
import com.whatever.ofi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final UserService userService;

    private final CoordinatorService coordinatorService;

    private final BoardService boardService;

    private final BCryptPasswordEncoder encoder;

    @PostConstruct
    public void userInit() {
        UserProfileRequest dto1 = new UserProfileRequest("tes1@naver.com", encoder.encode("qwer1234"),
                "테스트1", 170, 60, Gender.MALE, Shape.NATURAL, new ArrayList<>(List.of("미니멀", "힙합", "스포티")));

        UserProfileRequest dto2 = new UserProfileRequest("test2@naver.com", encoder.encode("qwer1234"),
                "테스트2", 165, 55, Gender.FEMALE, Shape.WAVE, new ArrayList<>(List.of("아메카지", "캐주얼")));

        UserProfileRequest dto3 = new UserProfileRequest("test3@naver.com", encoder.encode("qwer1234"),
                "테스트3", 180, 75, Gender.MALE, Shape.STRAIGHT, new ArrayList<>(List.of("러블리", "시티보이", "스트릿")));

        UserProfileRequest dto4 = new UserProfileRequest("test4@naver.com", encoder.encode("qwer1234"),
                "테스트4", 160, 50, Gender.FEMALE, Shape.NATURAL, new ArrayList<>(List.of("이지캐주얼", "유니크")));

        UserProfileRequest dto5 = new UserProfileRequest("test5@naver.com", encoder.encode("qwer1234"),
                "테스트5", 175, 70, Gender.MALE, Shape.WAVE, new ArrayList<>(List.of("힙합", "레트로")));

        userService.join(dto1);
        userService.join(dto2);
        userService.join(dto3);
        userService.join(dto4);
        userService.join(dto5);
    }

    @PostConstruct
    public void coordinatorInit() {
        CoordinatorProfileRequest dto1 = new CoordinatorProfileRequest("tes1@naver.com", encoder.encode("qwer1234"),
                "테스트1", "www.naver.com", "test1.png", "잘부탁드립니다~!", Gender.MALE,  170, 60, 942, 24,  new ArrayList<>(List.of("미니멀", "힙합", "스포티")));

        CoordinatorProfileRequest dto2 = new CoordinatorProfileRequest("test2@naver.com", encoder.encode("qwer1234"),
                "테스트2", "www.google.com", "test2.png", "환영합니다!", Gender.FEMALE, 165, 55, 865, 28, new ArrayList<>(List.of("아메카지", "캐주얼")));

        CoordinatorProfileRequest dto3 = new CoordinatorProfileRequest("test3@naver.com", encoder.encode("qwer1234"),
                "테스트3", "www.yahoo.com", "test3.png", "안녕하세요!", Gender.MALE, 180, 75, 721, 31, new ArrayList<>(List.of("러블리", "시티보이", "스트릿")));

        CoordinatorProfileRequest dto4 = new CoordinatorProfileRequest("test4@naver.com", encoder.encode("qwer1234"),
                "테스트4", "www.bing.com", "test4.png", "반갑습니다!", Gender.FEMALE, 160, 50, 638, 329, new ArrayList<>(List.of("이지캐주얼", "유니크")));

        CoordinatorProfileRequest dto5 = new CoordinatorProfileRequest("test5@naver.com", encoder.encode("qwer1234"),
                "테스트5", "www.duckduckgo.com", "test5.png", "만나서 기쁩니다!", Gender.MALE, 175, 70, 799, 127, new ArrayList<>(List.of("힙합", "레트로")));


        coordinatorService.join(dto1);
        coordinatorService.join(dto2);
        coordinatorService.join(dto3);
        coordinatorService.join(dto4);
        coordinatorService.join(dto5);
    }

    @PostConstruct
    public void boardInit() {
        BoardRequest dto1 = new BoardRequest(1L, "힙합", 12, "가을",
                "일상", "가을 코디입니다~", "test1.png");

        BoardRequest dto2 = new BoardRequest(1L, "로맨틱", 8, "봄",
                "데이트", "봄날의 데이트룩~", "test2.png");

        BoardRequest dto3 = new BoardRequest(2L, "클래식", 6, "겨울",
                "일상", "겨울의 클래식 스타일~", "test3.png");

        BoardRequest dto4 = new BoardRequest(2L, "스트릿", 15, "여름",
                "스트릿패션", "여름에 어울리는 스트릿룩~", "test4.png");

        BoardRequest dto5 = new BoardRequest(3L, "캐주얼", 10, "봄",
                "일상", "봄의 캐주얼 스타일~", "test5.png");

        BoardRequest dto6 = new BoardRequest(3L, "러블리", 9, "가을",
                "일상", "가을의 러블리 스타일~", "test1.png");

        BoardRequest dto7 = new BoardRequest(4L, "모던", 7, "겨울",
                "일상", "겨울의 모던 스타일~", "test2.png");

        BoardRequest dto8 = new BoardRequest(4L, "헌팅", 11, "여름",
                "헌팅패션", "여름에 어울리는 헌팅룩~", "test3.png");

        BoardRequest dto9 = new BoardRequest(5L, "아메카지", 14, "봄",
                "일상", "봄의 아메카지 스타일~", "test4.png");

        BoardRequest dto10 = new BoardRequest(5L, "플로럴", 13, "가을",
                "일상", "가을의 플로럴 스타일~", "test5.png");

        boardService.join(dto1);
        boardService.join(dto2);
        boardService.join(dto3);
        boardService.join(dto4);
        boardService.join(dto5);
        boardService.join(dto6);
        boardService.join(dto7);
        boardService.join(dto8);
        boardService.join(dto9);
        boardService.join(dto10);
    }
}
