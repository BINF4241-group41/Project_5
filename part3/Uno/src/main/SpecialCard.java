package main;

public abstract class SpecialCard implements UnoCard {

    protected Color color;

    public abstract Color getColor();

    public abstract void executeAction(UnoGame game);
}