package ru.itis.tarot_whispers.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.tarot_whispers.dto.PostDTO;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.repository.PostRepository;
import ru.itis.tarot_whispers.services.PostService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserServiceImpl userServiceImpl;

    @Override
    @Transactional
    public Post createPost(PostDTO postDTO) {
        User user = userServiceImpl.findById(postDTO.getUserId());

        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .imageUrl(postDTO.getImageUrl())
                .user(user)
                .build();
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public Post updatePost(UUID postId, PostDTO postDTO) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImageUrl(postDTO.getImageUrl());
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(UUID postId) {
        postRepository.deleteById(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPostById(UUID postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostsByUserId(UUID userId) {
        return postRepository.findByUserId(userId);
    }
}