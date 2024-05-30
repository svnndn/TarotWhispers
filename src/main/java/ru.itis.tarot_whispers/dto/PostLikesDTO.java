package ru.itis.tarot_whispers.dto;

import lombok.*;
import ru.itis.tarot_whispers.model.Post;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLikesDTO {
    private Post post;
    private int likesCount;
    private boolean likedByCurrentUser;
}