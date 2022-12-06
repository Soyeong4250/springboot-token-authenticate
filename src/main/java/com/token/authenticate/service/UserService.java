package com.token.authenticate.service;

import com.token.authenticate.TokenAuthenticateApplication;
import com.token.authenticate.domain.dto.UserJoinReq;
import com.token.authenticate.domain.dto.UserJoinRes;
import com.token.authenticate.domain.entity.User;
import com.token.authenticate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserJoinRes join(UserJoinReq request) {
        return null;
    }
}
