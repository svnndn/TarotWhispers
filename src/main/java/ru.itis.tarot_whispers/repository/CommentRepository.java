package ru.itis.tarot_whispers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.tarot_whispers.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(UUID post_id);
}