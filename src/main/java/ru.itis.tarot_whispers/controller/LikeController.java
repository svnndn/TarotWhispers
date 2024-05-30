package ru.itis.tarot_whispers.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.services.LikeService;
import ru.itis.tarot_whispers.services.PostService;
import ru.itis.tarot_whispers.services.UserService;

import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/posts/like")
public class LikeController {

    private final LikeService likeService;
    private final PostService postService;
    private final UserService userService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> toggleLike(@PathVariable UUID postId, Authentication authentication) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = postService.getPostById(postId);
        likeService.toggleLike(post, currentUser);

        return ResponseEntity.ok().build();
    }
}