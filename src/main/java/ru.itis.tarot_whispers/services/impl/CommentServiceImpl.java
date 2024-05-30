package ru.itis.tarot_whispers.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.tarot_whispers.dto.CommentDTO;
import ru.itis.tarot_whispers.model.Comment;
import ru.itis.tarot_whispers.model.Post;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.repository.CommentRepository;
import ru.itis.tarot_whispers.repository.PostRepository;
import ru.itis.tarot_whispers.repository.UsersRepository;
import ru.itis.tarot_whispers.services.CommentService;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UsersRepository userRepository;

    @Override
    @Transactional
    public Comment createComment(CommentDTO commentDTO) {
        User user = userRepository.findById(commentDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + commentDTO.getUserId()));

        Post post = postRepository.findById(commentDTO.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + commentDTO.getPostId()));

        Comment comment = Comment.builder()
                .text(commentDTO.getText())
                .user(user)
                .post(post)
                .build();

        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    @Transactional(readOnly = true)
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    @Override
    public List<Comment> getCommentsByPostId(UUID postId) {
        return commentRepository.findAllByPostId(postId);
    }
}