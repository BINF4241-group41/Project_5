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

    public void skipPlayer() {
        // set to next player
    }

    public void changeDirection() {
        // change direction
    }

    public void addCardToCurrentPlayer() {
        // draw card
    }

    public void initializeRound() {
        // init cards
        // set first card on discard pile
    }

    private void executeCardAction() {
        // execute action of top card on discard pile
    }

    private void regenerateDrawPile() {
        // take cards from discardPile, shuffle them and add them to drawPile
    }
}