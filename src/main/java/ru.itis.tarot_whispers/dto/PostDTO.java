package ru.itis.tarot_whispers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    private String content;

    @Size(max = 2048)
    private String imageUrl;

    private UUID userId;
}