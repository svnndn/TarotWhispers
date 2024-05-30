package ru.itis.tarot_whispers.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.tarot_whispers.dto.RegistrationForm;
import ru.itis.tarot_whispers.exception.UserAlreadyExistsException;
import ru.itis.tarot_whispers.model.Role;
import ru.itis.tarot_whispers.model.User;
import ru.itis.tarot_whispers.repository.UsersRepository;
import ru.itis.tarot_whispers.security.UserDetailsImpl;
import ru.itis.tarot_whispers.services.AuthService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsersRepository usersRepository;
    private final @Lazy PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationForm form) throws UserAlreadyExistsException {
        if (usersRepository.existsByUsername(form.getUsername())) {
            throw new UserAlreadyExistsException("User with this username already exists");
        }

        if (usersRepository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }

        User user = User.builder()
                .username(form.getUsername())
                .email(form.getEmail())
                .passwordHash(passwordEncoder.encode(form.getPassword()))
                .role(Role.ROLE_USER)
                .build();
        usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = optionalUser.get();
        return UserDetailsImpl.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPasswordHash())
                .roles(List.of(user.getRole()))
                .build();
    }
}