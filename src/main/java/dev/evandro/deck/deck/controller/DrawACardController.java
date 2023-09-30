package dev.evandro.deck.deck.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.evandro.deck.deck.model.DrawACard;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DrawACardController {

    @GetMapping("/teste")
    public ResponseEntity<?> recuperarCartas() {

        String url = "https://deckofcardsapi.com/api/deck/new/draw/?count=5";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        DrawACard drawACard = null;
        try {
            drawACard = objectMapper.readValue(response.getBody(), DrawACard.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if(response != null){
            return ResponseEntity.ok(drawACard);
        }
        return ResponseEntity.badRequest().build();
    }
}
