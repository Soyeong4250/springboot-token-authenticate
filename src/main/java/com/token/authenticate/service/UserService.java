package com.token.authenticate.service;

import com.token.authenticate.domain.dto.UserJoinReq;
import com.token.authenticate.domain.dto.UserJoinRes;
import com.token.authenticate.domain.entity.User;
import com.token.authenticate.exception.ErrorCode;
import com.token.authenticate.exception.TokenAuthenticateAppException;
import com.token.authenticate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserJoinRes join(UserJoinReq request) {

        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> {
                    throw new TokenAuthenticateAppException(ErrorCode.DUPLICATE_USER_NAME, "이미 존재하는 회원 입니다.");
                });

        User user = userRepository.save(request.toEntity(encoder.encode(request.getPassword())));
        return UserJoinRes.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .userRole(user.getRole().name())
                .build();
    }

    public String login(String userName, String password) {

        return "token";
    }
}
