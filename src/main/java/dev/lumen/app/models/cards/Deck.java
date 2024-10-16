package dev.lumen.app.models.cards;

import java.util.Collections;
import java.util.List;
import dev.sol.base.collections.FXObservableList;

public class Deck extends FXObservableList<Card> {

    private Boolean includeJokers;

    public Deck() {
        this(false, Card.WIDTH);

    }

    public Deck(int custom_width) {
        this(false, custom_width);
    }

    public Deck(boolean includeJokers, int custom_width) {
        this.includeJokers = includeJokers;
        initialize(custom_width);
    }

    public void initialize(int custom_width) {
        Card.Suit.LIST().forEach(suit -> {
            Card.Value.LIST().forEach(value -> {
                add(new Card(suit, value, custom_width));
            });
        });

        if (includeJokers) {
            add(new Card(Card.Suit.JOKER, Card.Value.RED, custom_width));
            add(new Card(Card.Suit.JOKER, Card.Value.BLACK, custom_width));
        }

    }

    public void shuffle() {
        Collections.shuffle(this);
    }

    public void returnCards(Card card) {
        if (!contains(card)) {
            addFirst(card);
        }
    }

    public void returnCards(List<Card> card) {
        addAll(card);
    }

    public Card deal() {
        return isEmpty() ? null : removeLast();
    }

    public Integer cardsLeft() {
        return this.size();
    }


}