package ru.itis.tarot_whispers.services;

import ru.itis.tarot_whispers.dto.CommentDTO;
import ru.itis.tarot_whispers.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Comment createComment(CommentDTO commentDTO);
    void deleteComment(Long commentId);
    Comment getCommentById(Long postId);
    List<Comment> getCommentsByPostId(UUID postId);
}