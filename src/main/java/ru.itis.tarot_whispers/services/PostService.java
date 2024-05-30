package ru.itis.tarot_whispers.services;

import ru.itis.tarot_whispers.dto.PostDTO;
import ru.itis.tarot_whispers.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post createPost(PostDTO postDTO);
    Post updatePost(UUID postId, PostDTO postDTO);
    void deletePost(UUID postId);
    Post getPostById(UUID postId);
    List<Post> getAllPosts();
    List<Post> getPostsByUserId(UUID userId);
}