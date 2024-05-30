package ru.itis.tarot_whispers.services.impl;

import org.springframework.stereotype.Service;
import ru.itis.tarot_whispers.model.Like;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.repository.LikeRepository;
import ru.itis.tarot_whispers.services.LikeService;

import java.util.List;
import java.util.UUID;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void toggleLike(Post post, User user) {
        List<Like> existingLikes = likeRepository.findByPostIdAndUserId(post.getId(), user.getId());
        if (!existingLikes.isEmpty()) {
            likeRepository.deleteAll(existingLikes);
        } else {
            Like like = Like.builder()
                    .post(post)
                    .user(user)
                    .build();
            likeRepository.save(like);
        }
    }

    @Override
    public boolean isPostLikedByUser(Post post, User user) {
        return !likeRepository.findByPostIdAndUserId(post.getId(), user.getId()).isEmpty();
    }
}