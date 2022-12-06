package com.token.authenticate.service;

import com.token.authenticate.domain.dto.UserJoinReq;
import com.token.authenticate.domain.dto.UserJoinRes;
import com.token.authenticate.domain.entity.User;
import com.token.authenticate.exception.ErrorCode;
import com.token.authenticate.exception.TokenAuthenticateAppException;
import com.token.authenticate.repository.UserRepository;
import com.token.authenticate.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Value("${jwt.token.secret}")
    private String secretKey;
    private long expireTime = 1000L * 60 * 60;

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
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new TokenAuthenticateAppException(ErrorCode.NOT_FOUND, String.format("%s와 일치하는 회원을 찾을 수 없습니다.", userName)));

        if(!encoder.matches(password, user.getPassword())) {
            throw new TokenAuthenticateAppException(ErrorCode.INVALID_PASSWORD, "userName 또는 password가 잘못 되었습니다.");
        }

        return JwtTokenUtil.createToken(userName, secretKey, expireTime);
    }
}
