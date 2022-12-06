package com.token.authenticate.controller;

import com.token.authenticate.domain.dto.ReviewCreateReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/reviews")
public class ReviewRestController {

    @PostMapping
    public String write(@RequestBody ReviewCreateReq request, Authentication authentication) {
        log.info("writer : {}", authentication.getName());
        return "리뷰 등록 성공";
    }
}
