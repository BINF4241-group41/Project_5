package main;

import java.util.Queue;
import java.util.Stack;


public class UnoGame {

    private Queue<Player> players;
    private Player winner;
    private Stack<UnoCard> drawPile;
    private Stack<UnoCard> discardPile;

    private boolean playerSaidUno;
    private Color selectedColorFromWildCard;


    public UnoGame(String[] names) {
        // set up game
    }

    public Player currentPlayer() {
        return new Player("placeHolder");
    }

    public Player nextPlayer() {
        return new Player("placeHolder");
    }

    public void skipPlayer() {
        // set to next player
    }

    public void changeDirection() {
        // change direction
    }

    public void addCardToCurrentPlayer() {
        // draw card
    }

    public void playRound() {
        // set first card on discard pile, execute it's action
        // play the game until winner is chosen
    }

    private boolean isValidAction(String actionString) {
        return false;
    }

    public void nextCommand(String command) {
        // makes testing the class easier
    }

    public UnoCard getTopCard() {
        // returns top card on draw pile
        return new NormalCard(Color.Blue, 7);
    }

    private void executeCardAction() {
        // execute action of top card on discard pile
    }

    private void regenerateDrawPile() {
        // take cards from discardPile, shuffle them and add them to drawPile
    }

    public Player getWinner() {
        return winner;
    }
}