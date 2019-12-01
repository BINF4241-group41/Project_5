package project;


public class Player {

    private String name;
    private Square position;

    Player(String playerName) {
        this.name = playerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public void leavePosition() {
        position.removePlayer();
    }

    public void setPosition(Square destination) {
        this.position = destination;
        // Should Player or Game handle this?
        position.addPlayer(this);
    }

    public Square getPosition() {
        return position;
    }
}