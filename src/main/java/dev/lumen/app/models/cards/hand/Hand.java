package dev.lumen.app.models.cards.hand;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import dev.lumen.app.models.cards.Card;
import dev.lumen.app.models.cards.Deck;
import dev.sol.base.collections.FXObservableList;

public abstract class Hand extends FXObservableList<Card> {
    private List<Card> hand;

    public Hand() {
        hand = new LinkedList<>();
    }

    public Card select(int position) {
        return hand.get(position);
    }

    public void add(Deck deck) {
        Card card = deck.deal();
        if (card != null) {
            hand.add(card);
        }

    }

    public void remove(Card card, Deck deck) {
        if (hand.contains(card)) {
            hand.remove(card);
        }

    }

    public void remove(Card card) {
        if (hand.contains(card)) {
            hand.remove(card);
        }

    }

    public void clear(Deck deck) {
        deck.getCards().addAll(hand);
        hand.clear();

    }

    public int count() {
        return hand.size();
    }

    public void sortBySuit() {
        Collections.sort(hand, Comparator.comparing(Card::geSuit));
    }

    public void sortByValue() {
        Collections.sort(hand, Comparator.comparing(Card::getValue));
    }

    public void shuffle() {
        Collections.shuffle(this);
    }

    protected abstract int calculate();

}
