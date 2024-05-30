package ru.itis.tarot_whispers.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.tarot_whispers.dto.UserDTO;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.security.CanAccessUser;
import ru.itis.tarot_whispers.services.UserService;

import java.util.UUID;

@Controller
@RequestMapping("/profile")
@AllArgsConstructor
public class UserProfileController {

    private final UserService userService;

    @GetMapping("/")
    public String redirectProfile() {
        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return "redirect:/profile/" + currentUser.getId();
    }

    @GetMapping("/{userId}")
    public String viewProfile(Model model, @PathVariable UUID userId) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("user", user);
        return "user_profile_view";
    }

    @CanAccessUser
    @GetMapping("/edit/{userId}")
    public String showEditProfileForm(@PathVariable UUID userId, Model model) {
        User user = userService.findById(userId);
        UserDTO userDTO = UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .password(user.getPasswordHash())
                .build();

        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("userId", userId);
        return "edit_user_profile_view";
    }

    @CanAccessUser
    @PostMapping("/edit/{userId}")
    public String editProfile(@PathVariable UUID userId, @ModelAttribute("userDTO") UserDTO userDTO) {
        userService.updateUser(userId, userDTO);
        SecurityContextHolder.clearContext();
        return "redirect:/logout";
    }

    @CanAccessUser
    @GetMapping("/delete/{userId}")
    public String showDeleteProfileConfirmation(@PathVariable UUID userId, Model model) {
        User user = userService.findById(userId);
        UserDetails currentUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.findByUsername(currentUserDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("user", user);
        return "delete_user_profile_confirmation";
    }

    @CanAccessUser
    @PostMapping("/delete/{userId}")
    public String deleteProfile(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return "redirect:/logout";
    }
}