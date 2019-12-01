package project;


public class LastSquare extends Square {

	private Player myPlayer = null;

	public LastSquare(int numberSquare) {
		this.numberSquare=numberSquare;
	}

	public boolean isOccupied() {
		return (myPlayer != null);
	}
	
	public void addPlayer(Player player) {
		myPlayer=player;
	}

	public void removePlayer() {
		myPlayer = null;
	}

	@Override
	public String getPlayerName() { return (myPlayer != null ? myPlayer.getName() : ""); }

	public String toString() {
		if (myPlayer != null) {
			return "[" + numberSquare + "<" + getPlayerName() + ">" + "]";
		}
		return "[" + numberSquare + "]";
	}
}
