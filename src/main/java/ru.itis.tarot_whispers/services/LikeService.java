package ru.itis.tarot_whispers.services;

import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;

public interface LikeService {
    void toggleLike(Post post, User user);
    boolean isPostLikedByUser(Post post, User user);
}