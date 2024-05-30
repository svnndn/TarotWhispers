package ru.itis.tarot_whispers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.tarot_whispers.repository.UsersRepository;
import ru.itis.tarot_whispers.services.AuthService;
import ru.itis.tarot_whispers.services.impl.AuthServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public AuthService authService(UsersRepository usersRepository, @Lazy PasswordEncoder passwordEncoder) {
        return new AuthServiceImpl(usersRepository, passwordEncoder);
    }
}