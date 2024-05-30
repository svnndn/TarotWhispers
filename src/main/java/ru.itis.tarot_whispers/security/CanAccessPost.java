package ru.itis.tarot_whispers.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('ROLE_ADMIN') or @postAccessService.canAccessPost(authentication, #id)")
public @interface CanAccessPost {
}