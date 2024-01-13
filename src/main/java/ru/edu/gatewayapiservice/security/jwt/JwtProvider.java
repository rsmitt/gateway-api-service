package ru.edu.gatewayapiservice.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import ru.edu.gatewayapiservice.security.CustomUserPrincipal;

public interface JwtProvider {
    String generateToken(CustomUserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
