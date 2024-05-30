package ru.itis.tarot_whispers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.StringWriter;

@Controller
@RequestMapping("/tarot")
public class TarotController {

    private final OkHttpClient client = new OkHttpClient();
    private final String apiUrl = "https://tarotapi.dev/api/v1/cards/random";

    @GetMapping("/daily-card")
    public String getRandomTarotCard(Model model) throws IOException {
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String responseBody = response.body().string();
            String cardName = extractCardName(responseBody);

            model.addAttribute("cardName", cardName);

            return "random_tarot_card";
        }
    }

    private String extractCardName(String responseBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(responseBody);
        ArrayNode cardsArray = (ArrayNode) jsonNode.get("cards");
        if (cardsArray != null && cardsArray.size() > 0) {
            JsonNode firstCard = cardsArray.get(0);
            String cardName = firstCard.get("name").asText();
            return cardName;
        } else {
            return "Unknown Card";
        }
    }
}