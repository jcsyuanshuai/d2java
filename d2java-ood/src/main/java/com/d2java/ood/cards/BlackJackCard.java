package com.d2java.ood.cards;


public class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    @Override
    public int value() {
        return 0;
    }
}
