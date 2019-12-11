package main;

public class WildCard extends SpecialCard {

    public WildCard() {
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
        // do nothing
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