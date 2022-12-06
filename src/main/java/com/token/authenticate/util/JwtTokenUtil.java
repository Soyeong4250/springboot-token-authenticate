package com.token.authenticate.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    public static String createToken(String userName, String key, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("userName", userName);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact()
                ;
    }

    private static Claims extractClaims(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    public static String getUserName(String token, String secretKey) {
        return extractClaims(token, secretKey).get("userName", String.class);
    }

    public static boolean isExpired(String token, String secretKey) {
        Date expiredDate = extractClaims(token, secretKey).getExpiration();
        return expiredDate.before(new Date());
    }
}
