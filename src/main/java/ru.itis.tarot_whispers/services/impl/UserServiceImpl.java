package ru.itis.tarot_whispers.services.impl;

import lombok.AllArgsConstructor;import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.tarot_whispers.dto.UserDTO;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.repository.UsersRepository;
import ru.itis.tarot_whispers.services.UserService;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public User findById(UUID userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public void deleteUser(UUID userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    @Transactional
    public void updateUser(UUID userId, UserDTO userDTO) {
        User user = usersRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setPasswordHash(passwordEncoder.encode(userDTO.getPassword()));
        usersRepository.save(user);
    }
}