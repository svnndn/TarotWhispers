package ru.itis.tarot_whispers.controller;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.tarot_whispers.dto.RegistrationForm;
import ru.itis.tarot_whispers.exception.UserAlreadyExistsException;
import ru.itis.tarot_whispers.services.impl.AuthServiceImpl;

@Controller
@AllArgsConstructor
public class AuthorizationController {
    private final AuthServiceImpl authServiceImpl;

    @GetMapping("/sign-in")
    String signInView(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("errorMessage", error);
        return "sign_in_view";
    }

    @GetMapping("/sign-up")
    String signUpView() {
        return "sign_up_view";
    }

    @PostMapping("/sign-up")
    String signUp(@ModelAttribute @Valid RegistrationForm form, Model model) {
        try {
            authServiceImpl.register(form);
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("errorMessage", "User with this username or email already exists");
            return "sign_up_view";
        }
        return "redirect:/sign-in";
    }
}
