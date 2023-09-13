package com.whatever.ofi.service;

import com.whatever.ofi.domain.User;
import com.whatever.ofi.domain.UserProfile;
import com.whatever.ofi.domain.UserStyle;
import com.whatever.ofi.dto.UserProfileRequest;
import com.whatever.ofi.dto.UserRequest;
import com.whatever.ofi.dto.UserStyleRequest;
import com.whatever.ofi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(UserRequest dto) {
        userRepository.save(dto.toEntity());
    }

    @Transactional
    public void addProfile(UserProfileRequest dto) {
        User user = userRepository.findOne(dto.getUser_id());
        UserProfile userProfile = dto.toEntity();
        userProfile.setUser(user);

        userRepository.saveProfile(userProfile);
    }

    @Transactional
    public void addStyle(UserStyleRequest dto) {
        User user = userRepository.findOne(dto.getUser_id());

        for(String style : dto.getStyles()) {
            UserStyle userStyle = new UserStyle(style);
            user.addStyle(userStyle);

            userRepository.saveStyle(userStyle);
        }
    }
}
