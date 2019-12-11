package main;

public class WildDrawFourCard extends SpecialCard {

    public WildDrawFourCard() {
        // init
    }

    @Override
    public Color getColor() {
        return Color.Red;
    }

    public void chooseColor(Color color) {
        // set color
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