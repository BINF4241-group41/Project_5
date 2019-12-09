public class NormalCard implements UnoCard {

    private Color color;
    private int number;

    @Override
    public boolean canBePlayed() {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}