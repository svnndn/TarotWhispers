package ru.itis.tarot_whispers.services;

import ru.itis.tarot_whispers.dto.UserDTO;
import ru.itis.tarot_whispers.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User findById(UUID userId);
    void updateUser(UUID userId, UserDTO userDTO);
    void deleteUser(UUID userId);
}