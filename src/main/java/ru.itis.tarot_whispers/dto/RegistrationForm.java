package ru.itis.tarot_whispers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RegistrationForm {
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    @Length(min = 7)
    private String password;
}