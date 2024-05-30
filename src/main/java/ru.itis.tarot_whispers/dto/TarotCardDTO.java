package ru.itis.tarot_whispers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarotCardDTO {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    private String meaning;

    @Size(max = 2048)
    private String imageUrl;
}