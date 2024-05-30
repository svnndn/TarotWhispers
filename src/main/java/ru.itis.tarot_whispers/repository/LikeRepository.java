package ru.itis.tarot_whispers.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.tarot_whispers.model.Like;

import java.util.List;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPostIdAndUserId(UUID post_id, UUID user_id);
}