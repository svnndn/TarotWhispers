package ru.itis.tarot_whispers.services;

import ru.itis.tarot_whispers.model.TarotCard;

import java.util.List;

public interface TarotCardService {
    TarotCard findById(Long id);
    TarotCard findByName(String name);
    List<TarotCard> getAllTarotCards();
}