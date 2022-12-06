package com.token.authenticate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginReq {

    private String userName;
    private String password;

}
