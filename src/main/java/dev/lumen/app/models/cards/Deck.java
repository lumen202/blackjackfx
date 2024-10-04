package dev.lumen.app.models.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class Deck {

    private Boolean includeJokers;
    private List<Card> cards;

    public Deck() {
        this(false);

    }

    public Deck(boolean includeJokers) {
        cards = new LinkedList<>();
        this.includeJokers = includeJokers;
        initialize();
    }

    public void initialize() {
        cards = new LinkedList<>();
        Card.Suit.LIST().forEach(suit -> {
            Card.Value.LIST().forEach(value -> {
                cards.add(new Card(suit, value));
            });
        });

        if (includeJokers) {
            cards.add(new Card(Card.Suit.JOKER, Card.Value.RED));
            cards.add(new Card(Card.Suit.JOKER, Card.Value.BLACK));
        }

    }

    public void shuffle() {
        initialize();
        ;
        Collections.shuffle(cards);
    }

    public void add(Card card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    public void returnCards(List<Card> card) {
        cards.addAll(card);
    }

    public Card deal() {
        return cards.isEmpty() ? null : cards.removeLast();
    }

    public Integer cardsLeft() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

}
