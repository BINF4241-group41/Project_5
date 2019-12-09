package main;

import main.Color;

public class NormalCard implements UnoCard {

    private Color color;
    private int number;


    public NormalCard(Color color, int number) {
        // init
    }

    public Color getColor() {
        return Color.Wild;
    }

    public int getNumber() {
        return -1;
    }

    @Override
    public boolean canBePlayed(UnoCard card) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}