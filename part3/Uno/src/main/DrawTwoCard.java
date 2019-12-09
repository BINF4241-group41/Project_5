package main;

import main.Color;

public class DrawTwoCard extends SpecialCard {

    public DrawTwoCard(Color color) {
        // init
    }

    public Color getColor() {
        return Color.Wild;
    }

    @Override
    public void executeAction(UnoGame game) {
        // do action
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean canBePlayed(UnoCard card) {
        return false;
    }
}
