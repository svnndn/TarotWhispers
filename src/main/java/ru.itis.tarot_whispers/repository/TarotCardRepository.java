package ru.itis.tarot_whispers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.tarot_whispers.model.TarotCard;
import ru.itis.tarot_whispers.model.User;

import java.util.Optional;

public interface TarotCardRepository extends JpaRepository<TarotCard, Long> {
    Optional<TarotCard> findByName(String name);
}