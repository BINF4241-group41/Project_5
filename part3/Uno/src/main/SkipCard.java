package main;

public class SkipCard extends SpecialCard {

    public SkipCard(Color color) {
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