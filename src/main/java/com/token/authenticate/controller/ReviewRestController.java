package com.token.authenticate.controller;

import com.token.authenticate.domain.dto.ReviewCreateReq;
import com.token.authenticate.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/reviews")
public class ReviewRestController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<String> write(@RequestBody ReviewCreateReq request, Authentication authentication) {
        log.info("writer : {}", authentication.getName());
        return ResponseEntity.ok()
                .body(reviewService.write(authentication.getName()));
    }
}
