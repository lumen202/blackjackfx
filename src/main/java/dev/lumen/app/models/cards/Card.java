package dev.lumen.app.models.cards;

import java.util.LinkedList;
import java.util.List;

public class Card {

    public static enum Suit {
        CLUBS("Clubs"),
        DIAMONDS("Diamonds"),
        HEARTS("Hearts"),
        SPADES("Spades"),
        JOKER("Joker");

        private String display;

        private Suit(String display) {
            this.display = display;
        }

        @Override
        public String toString() {
            return display;
        }

        public static List<Suit> LIST() {
            List<Suit> list = new LinkedList<>(List.of(values()));
            list.removeLast();
            return list;
        }
    }

    public static enum Value {

        ACE("Ace", 1),
        TWO("Two", 2),
        THREE("Three", 3),
        FOUR("Four", 4),
        FIVE("Five", 5),
        SIX("Six", 6),
        SEVEN("Seven", 7),
        EIGHT("Eight", 8),
        NINE("Nine", 9),
        TEN("Ten", 10),
        JACK("Jack", 11),
        QUEEN("Queen", 12),
        KING("King", 13),
        RED("Joker (Red)", -1),
        BLACK("Joker (Black)", -1);

        private String display;
        private int value;

        private Value(String display, int value) {
            this.display = display;
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setDisplay(String display) {
            this.display = display;
        };

        public Integer toInt() {
            return value;
        }

        @Override
        public String toString() {
            return display;
        }

        public static List<Value> LIST() {
            List<Value> list = new LinkedList<>(List.of(values()));

            list.removeLast();
            list.removeLast();
            return list;
        }
    }

    private Suit suite;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suite = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suite;
    }

    public Value getValue() {
        return value;
    }

    public String display() {
        if (suite == Suit.JOKER) {
            return suite + " " + value;
        }
        return value + " of " + suite;
    }

}
