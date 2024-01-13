package ru.edu.gatewayapiservice.service;


import ru.edu.gatewayapiservice.model.User;

public interface AuthenticationService {
    User signInAndReturnJwt(User signInRequest);
}
