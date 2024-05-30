package ru.itis.tarot_whispers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import ru.itis.tarot_whispers.model.Role;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    @Length(min = 7)
    private String password;
    @NotBlank
    private Role role;
}