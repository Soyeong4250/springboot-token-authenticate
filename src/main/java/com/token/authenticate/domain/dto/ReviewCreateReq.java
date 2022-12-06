package com.token.authenticate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewCreateReq {

    private Long hospitalId;
    private String title;
    private String content;
    private String userName;

}
