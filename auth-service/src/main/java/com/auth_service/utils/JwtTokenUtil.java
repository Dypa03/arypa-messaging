package com.auth_service.utils;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtTokenUtil {
    Map<String, String> env = System.getenv();

    private String SECRET_KEY = env.get("SECRET_KEY");

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    
}
