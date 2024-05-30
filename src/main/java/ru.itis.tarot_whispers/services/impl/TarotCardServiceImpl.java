package ru.itis.tarot_whispers.services.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.tarot_whispers.model.TarotCard;
import ru.itis.tarot_whispers.repository.TarotCardRepository;
import ru.itis.tarot_whispers.services.TarotCardService;

import java.util.List;

@Service
@AllArgsConstructor
public class TarotCardServiceImpl implements TarotCardService {
    private final TarotCardRepository tarotCardRepository;
    @Override
    @Transactional(readOnly = true)
    public TarotCard findByName(String name) {
        return tarotCardRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Tarot card not found"));
    }
    @Override
    @Transactional(readOnly = true)
    public TarotCard findById(Long id) {
        return tarotCardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarot card not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TarotCard> getAllTarotCards() {
        return tarotCardRepository.findAll();
    }
}