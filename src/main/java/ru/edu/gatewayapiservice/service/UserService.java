package ru.edu.gatewayapiservice.service;

import ru.edu.gatewayapiservice.model.Role;
import ru.edu.gatewayapiservice.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
