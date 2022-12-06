package com.token.authenticate.controller;

import com.token.authenticate.domain.dto.UserJoinReq;
import com.token.authenticate.domain.dto.UserJoinRes;
import com.token.authenticate.domain.dto.UserLoginReq;
import com.token.authenticate.domain.dto.UserLoginRes;
import com.token.authenticate.domain.entity.Response;
import com.token.authenticate.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinRes> join(@RequestBody UserJoinReq userJoinReq) {
        UserJoinRes user = userService.join(userJoinReq);
        return Response.success(new UserJoinRes(user.getUserName(), user.getEmail(), user.getUserRole()));
    }

    @PostMapping("/login")
    public Response<UserLoginRes> login(@RequestBody UserLoginReq userLoginReq) {
        String token = userService.login(userLoginReq.getUserName(), userLoginReq.getPassword());
        return Response.success(new UserLoginRes("token"));
    }

}
