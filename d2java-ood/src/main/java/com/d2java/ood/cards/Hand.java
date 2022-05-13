package com.d2java.ood.cards;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Hand<T extends Card> {
    protected ArrayList<T> cards = Lists.newArrayList();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}
