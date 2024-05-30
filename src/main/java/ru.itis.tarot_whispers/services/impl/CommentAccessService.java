package ru.itis.tarot_whispers.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.tarot_whispers.model.Comment;
import ru.itis.tarot_whispers.services.CommentService;

import java.util.UUID;

@Service
public class CommentAccessService {
    private final CommentService commentService;

    public CommentAccessService(CommentService commentService) {
        this.commentService = commentService;
    }

    public boolean canAccessComment(Authentication authentication, Long id) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Comment comment = commentService.getCommentById(id);
        return userDetails.getUsername().equals(comment.getUser().getUsername());
    }
}