package ru.itis.tarot_whispers.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.services.UserService;

import java.util.UUID;

@Service
public class UserAccessService {
    private final UserService userService;

    public UserAccessService(UserService userService) {
        this.userService = userService;
    }

    public boolean canAccessUser(Authentication authentication, UUID id) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findById(id);
        return userDetails.getUsername().equals(user.getUsername()) ||
                userDetails.getAuthorities().stream()
                        .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
    }
}