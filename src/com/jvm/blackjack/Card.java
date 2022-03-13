package com.jvm.blackjack;

import java.util.Collections;
import java.util.LinkedList;

public class Card {
    Integer value;

    Card(Integer value) {
        this.value = value;
    }

    public static LinkedList<Card> generateDeck() {
        LinkedList<Card> list = new LinkedList<Card>();

        Integer values = 13;
        Integer suits = 4;

        for (int i = 0; i < suits; i++) {
            for (int j = 0; j < values; j++) {
                list.add(new Card(j + 1));
            }
        }

        Collections.shuffle(list);

        return list;
    }
}
