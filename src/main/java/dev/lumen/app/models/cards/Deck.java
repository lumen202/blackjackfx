package dev.lumen.app.models.cards;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Deck implements ObservableList<Card> {

    private ObservableList<Card> cardList;
    private Boolean includeJokers;

    public Deck() {
        this(false);

    }

    public Deck(boolean includeJokers) {
        cardList = FXCollections.observableArrayList();
        this.includeJokers = includeJokers;
        initialize();
    }

    public void initialize() {
        Card.Suit.LIST().forEach(suit -> {
            Card.Value.LIST().forEach(value -> {
                cardList.add(new Card(suit, value));
            });
        });

        if (includeJokers) {
            cardList.add(new Card(Card.Suit.JOKER, Card.Value.RED));
            cardList.add(new Card(Card.Suit.JOKER, Card.Value.BLACK));
        }

    }

    public void shuffle() {
        Collections.shuffle(cardList);
    }

    public void returnCards(Card card) {
        if (cardList.contains(card)) {
            cardList.add(card);
        }
    }

    public void returnCards(List<Card> card) {
        cardList.addAll(card);
    }

    public Card deal() {
        return cardList.isEmpty() ? null : cardList.removeLast();
    }

    public Integer cardsLeft() {
        return cardList.size();
    }

    public List<Card> getCards() {
        return cardList;
    }

    @Override
    public int size() {
        return cardList.size();
    }

    @Override
    public boolean isEmpty() {
        return cardList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return cardList.contains(o);
    }

    @Override
    public Iterator<Card> iterator() {
        return cardList.iterator();
    }

    @Override
    public Object[] toArray() {
        return cardList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return cardList.toArray(a);
    }

    @Override
    public boolean add(Card e) {
        return cardList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return cardList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return cardList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Card> c) {
        return cardList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Card> c) {
        return cardList.addAll(index, null);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return cardList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return cardList.retainAll(c);
    }

    @Override
    public void clear() {
        cardList.clear();
    }

    @Override
    public Card get(int index) {
        return cardList.get(index);
    }

    @Override
    public Card set(int index, Card element) {
        return cardList.set(index, element);
    }

    @Override
    public void add(int index, Card element) {
        cardList.add(index, element);
    }

    @Override
    public Card remove(int index) {
        return cardList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return cardList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return cardList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Card> listIterator() {
        return cardList.listIterator();
    }

    @Override
    public ListIterator<Card> listIterator(int index) {
        return cardList.listIterator(index);
    }

    @Override
    public List<Card> subList(int fromIndex, int toIndex) {
        return cardList.subList(fromIndex, toIndex);
    }

    @Override
    public void addListener(InvalidationListener listener) {
        cardList.addListener(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        cardList.removeListener(listener);
    }

    @Override
    public void addListener(ListChangeListener<? super Card> listener) {
        cardList.addListener(listener);
    }

    @Override
    public void removeListener(ListChangeListener<? super Card> listener) {
        cardList.removeListener(listener);
    }

    @Override
    public boolean addAll(Card... elements) {
        return cardList.addAll(elements);
    }

    @Override
    public boolean setAll(Card... elements) {
        return cardList.setAll(elements);
    }

    @Override
    public boolean setAll(Collection<? extends Card> col) {
        return cardList.setAll(col);
    }

    @Override
    public boolean removeAll(Card... elements) {
        return cardList.removeAll(elements);
    }

    @Override
    public boolean retainAll(Card... elements) {
        return cardList.retainAll(elements);
    }

    @Override
    public void remove(int from, int to) {
        cardList.remove(from, to);
    }

}
