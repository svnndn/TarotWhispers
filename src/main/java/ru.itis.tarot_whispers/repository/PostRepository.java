package ru.itis.tarot_whispers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.tarot_whispers.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByUserId(UUID userId);
}