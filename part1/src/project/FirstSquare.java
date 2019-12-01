package project;

import java.util.ArrayList;


public class FirstSquare extends Square {

	private ArrayList<Player> players;
	
	public FirstSquare(int numberSquare) {
		this.numberSquare=numberSquare;
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer() {
		players.remove(0);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public String toString() {
		return "[" + numberSquare + getPlayerNamesList() + "]";
	}

	public boolean isOccupied() {
		return false;
	}

	// helper function for toString
	private String getPlayerNamesList() {
		String s="";
		for (Player p : players) {
			s += "<" + p.getName() + ">";
		}
		return s;
	}
}
