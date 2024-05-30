package ru.itis.tarot_whispers.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('ROLE_ADMIN') or @commentAccessService.canAccessComment(authentication, #commentId)")
public @interface CanAccessComment {
}