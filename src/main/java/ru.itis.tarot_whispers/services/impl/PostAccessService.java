package ru.itis.tarot_whispers.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.services.PostService;

import java.util.UUID;

@Service
public class PostAccessService {
    private final PostService postService;

    public PostAccessService(PostService postService) {
        this.postService = postService;
    }

    public boolean canAccessPost(Authentication authentication, UUID id) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Post post = postService.getPostById(id);
        return userDetails.getUsername().equals(post.getUser().getUsername());
    }
}