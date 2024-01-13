package ru.edu.gatewayapiservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.edu.gatewayapiservice.model.User;
import ru.edu.gatewayapiservice.security.CustomUserPrincipal;
import ru.edu.gatewayapiservice.security.jwt.JwtProvider;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJwt(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        CustomUserPrincipal customUserPrincipal = (CustomUserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(customUserPrincipal);

        User signInUser = customUserPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}
