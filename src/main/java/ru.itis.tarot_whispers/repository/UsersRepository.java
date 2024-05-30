package ru.itis.tarot_whispers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.tarot_whispers.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
