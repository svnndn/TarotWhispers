package ru.itis.tarot_whispers.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.itis.tarot_whispers.dto.RegistrationForm;
import ru.itis.tarot_whispers.exception.UserAlreadyExistsException;

public interface AuthService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    void register(RegistrationForm form) throws UserAlreadyExistsException;
}
