package ru.itis.tarot_whispers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.tarot_whispers.model.TarotCard;
import ru.itis.tarot_whispers.services.TarotCardService;

import java.util.List;

@Controller
@RequestMapping("/tarot-cards")
@RequiredArgsConstructor
public class TarotCardController {
    private final TarotCardService tarotCardService;

    @GetMapping
    public String getAllTarotCards(Model model) {
        List<TarotCard> tarotCards = tarotCardService.getAllTarotCards();
        model.addAttribute("tarotCards", tarotCards);
        return "all_tarot_cards_view";
    }

    @GetMapping("/{id}")
    public String getTarotCardById(@PathVariable Long id, Model model) {
        TarotCard tarotCard = tarotCardService.findById(id);
        model.addAttribute("tarotCard", tarotCard);
        return "tarot_card_view";
    }
}