package ru.itis.tarot_whispers.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.tarot_whispers.dto.CommentDTO;
import ru.itis.tarot_whispers.model.Comment;
import ru.itis.tarot_whispers.security.CanAccessComment;
import ru.itis.tarot_whispers.services.CommentService;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestParam("text") String text,
                                             @RequestParam("userId") UUID userId,
                                             @RequestParam("postId") UUID postId) {
        CommentDTO commentDTO = CommentDTO.builder()
                .text(text)
                .userId(userId)
                .postId(postId)
                .build();

        Comment comment = commentService.createComment(commentDTO);

        String commentJson = "{"
                + "\"id\": \"" + comment.getId() + "\","
                + "\"text\": \"" + comment.getText() + "\","
                + "\"user\": {"
                +     "\"id\": \"" + comment.getUser().getId() + "\","
                +     "\"username\": \"" + comment.getUser().getUsername() + "\""
                + "},"
                + "\"post\": {"
                +     "\"id\": \"" + comment.getPost().getId() + "\","
                +     "\"createdDate\": \"" + comment.getPost().getCreatedDate() + "\","
                +     "\"updatedDate\": \"" + comment.getPost().getUpdatedDate() + "\""
                + "}"
                + "}";

        return ResponseEntity.status(HttpStatus.CREATED).body(commentJson);
    }

    @CanAccessComment
    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}