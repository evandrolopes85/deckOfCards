package dev.evandro.deck.deck.model;

import java.util.List;

public class DrawACard {
    private boolean success;
    private String deck_id;

    private List<Card> cards;

    private Integer remaining;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCads(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
