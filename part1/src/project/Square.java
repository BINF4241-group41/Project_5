package project;


public abstract class Square {

    protected int numberSquare;

    public abstract boolean isOccupied();
    public abstract String toString();
    public abstract void addPlayer(Player player); // Game should check if already occupied.
    public abstract void removePlayer();

    public String getPlayerName() {
        return "";
    }
    public int getNumberSquare() {
        return numberSquare;
    }
    
}
