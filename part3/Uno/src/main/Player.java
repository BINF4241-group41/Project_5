package main;

import java.util.ArrayList;


public class Player {

    private ArrayList<UnoCard> cards;
    private String name;
    private int points;


    public Player(String name) {
        // init
    }

    public void addCard(UnoCard card) {
        // add card
    }

    public void removeCard(UnoCard card) {
        // remove matching card
    }

    public Iterable<UnoCard> getCardsIterator() {
        return cards;
    }

    public String getName() {
        return "";
    }

    public void addPoints(int points) {
        // add points
    }

    public int getPoints() {
        return 0;
    }
}
