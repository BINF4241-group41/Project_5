package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;


public class UnoGameTest {


    UnoGame myGame;


    /**
     * Set up game for tests.
     */
    @BeforeEach
    void setUpGame() {
        UnoGame myGame = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Test the initialization (players and direction).
     */
    @Test
    void playerDirectionTest() {
        assertTrue(myGame.currentPlayer().getName() == "p1");
        assertTrue(myGame.nextPlayer().getName() == "p2");
    }

    /**
     * Test the initialization (no. of cards of players).
     */
    @Test
    void playerCardNumberTest() {

        int noOfCards = 0;

        for (UnoCard card: myGame.currentPlayer().getCardsIterator()) {
            ++noOfCards;
        }

        assertEquals(7, noOfCards, "SetUp failed.");

        noOfCards = 0;

        for (UnoCard card: myGame.nextPlayer().getCardsIterator()) {
            ++noOfCards;
        }

        assertEquals(7, noOfCards, "Incorrect number of cards after initialization.");
    }

    /**
     * Test the initialization (top card set).
     */
    @Test
    void topCardTest() {
        assertNotNull(myGame.getTopCard(), "Failed to set top card.");
    }

    /**
     * Test if the player gets correctly skipped.
     */
    @Test
    void skipPlayerTest() {
        assertTrue(myGame.currentPlayer().getName() == "p1", "SetUp failed.");
        assertTrue(myGame.nextPlayer().getName() == "p2", "SetUp failed.");

        myGame.skipPlayer();

        assertTrue(myGame.nextPlayer().getName() == "p3");

        myGame.skipPlayer();

        assertTrue(myGame.nextPlayer().getName() == "p1");
    }

    /**
     * Test if the direction gets reversed.
     */
    @Test
    void reverseDirectionTest() {
        assertTrue(myGame.currentPlayer().getName() == "p1", "SetUp failed.");
        assertTrue(myGame.nextPlayer().getName() == "p2", "SetUp failed.");

        myGame.changeDirection();

        assertTrue(myGame.nextPlayer().getName() == "p3");

        myGame.changeDirection();

        assertTrue(myGame.nextPlayer().getName() == "p2");
    }

    /**
     * Test if adding a card to current player works correctly.
     */
    @Test
    void addCardTest() {
        int noOfCards = 0;

        for (UnoCard card: myGame.currentPlayer().getCardsIterator()) {
            ++noOfCards;
        }

        myGame.addCardToCurrentPlayer();

        int noOfCardsAfter = 0;

        for (UnoCard card: myGame.currentPlayer().getCardsIterator()) {
            ++noOfCardsAfter;
        }

        assertEquals(noOfCardsAfter, noOfCards + 1, "Incorrect number of cards after adding one.");
    }

    /**
     * Test entering invalid commands.
     */
    @Test
    void testInvalidCommands() {

        myGame.playRound(); // start round

        Player currentPlayer = myGame.currentPlayer();
        Player nextPlayer = myGame.nextPlayer();

        for (int counter = 0; counter < 100; ++counter) {
            myGame.nextCommand("abcdef");
            myGame.nextCommand("Yellow22");
            myGame.nextCommand("Draw");
            myGame.nextCommand("Finish");
            assertEquals(currentPlayer, myGame.currentPlayer(), "Game ended turn despite invalid commands.");
            assertEquals(nextPlayer, myGame.nextPlayer(), "Game changed next player despite invalid commands.");
            myGame.nextCommand("!Finish");
            assertEquals(currentPlayer, myGame.currentPlayer(), "Game ended turn despite not having done anything.");
            assertEquals(nextPlayer, myGame.nextPlayer(), "Game changed next player despite not having done anything.");
        }
    }

    /**
     * Test playing an invalid card.
     */
    @Test
    void testPlayingInValidCard() {

        boolean playerHadInValidCard = false;
        UnoCard invalidCard = null;

        for (int counter = 0; counter < 100; ++counter) {
            myGame.playRound(); // start round

            for (UnoCard card : myGame.currentPlayer().getCardsIterator()) {
                if (!card.canBePlayed(myGame.getTopCard())) {
                    myGame.nextCommand(card.toString());
                    playerHadInValidCard = true;
                    invalidCard = card;
                    break;
                }
            }
            setUpGame();
        }

        if (!playerHadInValidCard) {
            fail("In 100 rounds the first player never had an invalid card. Most likely an error occurred.");
        }

        assertNotEquals(invalidCard.toString(), myGame.getTopCard().toString(), "Game allowed invalid card to be played.");
    }

    /**
     * Test playing a valid card.
     */
    @Test
    void testPlayingValidCard() {

        boolean playerHadValidCard = false;
        UnoCard playedCard = null;

        for (int counter = 0; counter < 100; ++counter) {
            myGame.playRound(); // start round

            for (UnoCard card : myGame.currentPlayer().getCardsIterator()) {
                if (card.canBePlayed(myGame.getTopCard())) {
                    myGame.nextCommand(card.toString());
                    playerHadValidCard = true;
                    playedCard = card;
                    break;
                }
            }
            setUpGame();
        }

        if (!playerHadValidCard) {
            fail("In 100 rounds the first player never had a valid card. Most likely an error occurred.");
        }

        assertEquals(playedCard.toString(), myGame.getTopCard().toString(), "Played card doesn't match top card of discard pile.");
    }

    /**
     * Test just drawing a card and then finishing turn.
     */
    @Test
    void testJustDrawingCard() {

        Player nextPlayer = myGame.nextPlayer();

        int numBefore = 0;
        for (UnoCard card: myGame.currentPlayer().getCardsIterator()) {
            numBefore += 1;
        }

        myGame.playRound();
        myGame.nextCommand("!Draw");

        int numAfter = 0;
        for (UnoCard card: myGame.currentPlayer().getCardsIterator()) {
            numAfter += 1;
        }

        assertEquals(numAfter, numBefore + 1);

        myGame.nextCommand("!Finish");

        assertEquals(nextPlayer, myGame.currentPlayer());
    }

    /**
     * Test execution of the action of a valid special card (excluding wild/wilddrawfour cards).
     */
    @Test
    void testExecutionOfSpecialCardAction() {

        boolean playerHadSpecialCard = false;
        UnoCard playedCard = null;

        for (int counter = 0; counter < 200; ++counter) {
            myGame.playRound(); // start round

            for (UnoCard card : myGame.currentPlayer().getCardsIterator()) {
                if (card.canBePlayed(myGame.getTopCard()) && card instanceof SpecialCard && !(card instanceof WildCard)) {
                    myGame.nextCommand(card.toString());
                    playerHadSpecialCard = true;
                    playedCard = card;
                    break;
                }
            }
            setUpGame();
        }

        if (!playerHadSpecialCard) {
            fail("In 200 rounds the first player never had a valid special card (excluding wild cards). Most likely an error occurred.");
        }

        assertEquals(playedCard.toString(), myGame.getTopCard().toString(), "Played card doesn't match top card of discard pile.");
    }

    /**
     * Test playing correctly for 10 turns 50 times.
     */
    @Test
    void testPlayingSomeTurns() {

        for (int testCounter = 0; testCounter < 50; ++testCounter) {
            setUpGame();
            myGame.playRound();

            if (myGame.getTopCard() instanceof WildDrawFourCard) {
                fail("A WildDrawFour card was at the top of the pile at the beginning.");
            }

            for (int counter = 0; counter < 10; ++counter) {

                UnoCard playedCard = null;
                Player nextPlayer = myGame.nextPlayer();

                for (UnoCard card : myGame.currentPlayer().getCardsIterator()) {

                    if (card.canBePlayed(myGame.getTopCard())) {
                        myGame.nextCommand(card.toString());

                        if (card instanceof WildCard) {
                            myGame.nextCommand("!Red");
                        }
                        playedCard = card;
                    }
                }

                if (playedCard == null) {
                    myGame.nextCommand("!Draw");

                    for (UnoCard card : myGame.currentPlayer().getCardsIterator()) {

                        if (card.canBePlayed(myGame.getTopCard())) {
                            myGame.nextCommand(card.toString());

                            if (card instanceof WildCard) {
                                myGame.nextCommand("!Red");
                            }
                            playedCard = card;
                        }
                    }
                }

                myGame.nextCommand("!Finish");

                if (!(playedCard instanceof ReverseCard) || !(playedCard instanceof SkipCard)) {
                    assertEquals(nextPlayer, myGame.currentPlayer(), "Turn not correctly finished.");
                } else {
                    assertNotEquals(nextPlayer, myGame.currentPlayer(), "Turn not correctly finished.");
                }

                assertEquals(playedCard.toString(), myGame.getTopCard().toString(), "Played card doesn't match top card of discard pile.");
            }
        }
    }
}
