package main;

public class ReverseCard extends SpecialCard {

    public ReverseCard(Color color) {
        // init
    }

    @Override
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