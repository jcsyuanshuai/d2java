package com.d2java.ood.cards;

public abstract class Card {
    private boolean available = true;

    protected Suit suit;

    protected int faceValue;

    public Card(int c, Suit s) {
        this.faceValue = c;
        this.suit = s;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public void markAvailable() {
        this.available = true;
    }
}
