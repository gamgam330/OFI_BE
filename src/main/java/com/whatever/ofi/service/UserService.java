package com.whatever.ofi.service;

import com.whatever.ofi.config.Util;
import com.whatever.ofi.domain.User;
import com.whatever.ofi.requestDto.LoginRequest;
import com.whatever.ofi.requestDto.UserProfileRequest;
import com.whatever.ofi.requestDto.UserStyleRequest;
import com.whatever.ofi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final  BCryptPasswordEncoder encoder;

    @Value("${jwt.secret}")
    private String secretKey;

    @Transactional
    public void join(UserProfileRequest dto) {
        userRepository.save(dto.toEntity());
    }

    public String login(LoginRequest loginRequest) {

        // 1. Id가 틀린 경우
        if(userRepository.findByEmail(loginRequest.getEmail()) == null) return "Email Not Found";

        // 2. Pw가 틀린 경우
        User user = userRepository.findByPassword(loginRequest.getEmail());
        String encodePassword = encoder.encode(loginRequest.getPassword());

        // 사용자가 입력한 비밀번호 (rawPassword)와 암호화된 비밀번호 (hashedPassword)를 비교합니다.
        if(!encoder.matches(encodePassword, user.getPassword())) return "Password Not Equal";

        String nickname = user.getNickname();

        return Util.createJwt(nickname, secretKey);
    }
}
