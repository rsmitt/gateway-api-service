package ru.edu.gatewayapiservice.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.gatewayapiservice.model.Role;
import ru.edu.gatewayapiservice.model.User;
import ru.edu.gatewayapiservice.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return repository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void changeRole(Role newRole, String username) {
        repository.updateUserRole(username, newRole);
    }
}
