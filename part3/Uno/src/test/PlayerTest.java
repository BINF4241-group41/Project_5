package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests the Player class.
 */
public class PlayerTest {


    Player myPlayer;


    /**
     * Set up player for tests.
     */
    @BeforeEach
    void setUpPlayer() {
        myPlayer = new Player("PlayerName");
    }

    /**
     * Check for successful initialization (name, points and no cards).
     */
    @Test
    void initializationTest() {
        assertTrue(myPlayer.getName() == "PlayerName");
        assertEquals(0, myPlayer.getPoints());

        int cardCount = 0;
        for (UnoCard card: myPlayer.getCardsIterator()) {
            cardCount += 1;
        }
        assertEquals(0, cardCount);
    }

    /**
     * Check that points get initialized and added correctly.
     */
    @Test
    void pointsTest() {
        assertEquals(myPlayer.getPoints(), 0);
        myPlayer.addPoints(10);
        assertEquals(10, myPlayer.getPoints());
    }

    /**
     * Check that negative point values get ignored.
     */
    @Test
    void pointsNegativeTest() {
        assertEquals(0, myPlayer.getPoints());
        myPlayer.addPoints(-10);
        assertEquals(0, myPlayer.getPoints());
    }

    /**
     * Test addition and removal of cards (happy path test).
     */
    @Test
    void addCardTest() {
        UnoCard normalCard = new NormalCard(Color.Red, 6);
        UnoCard specialCard = new WildCard();

        myPlayer.addCard(normalCard);
        myPlayer.addCard(specialCard);

        int cardCount = 0;
        for (UnoCard card: myPlayer.getCardsIterator()) {
            assertTrue(card.toString() == normalCard.toString() || card.toString() == specialCard.toString());
            cardCount += 1;
        }
        assertEquals(2, cardCount);

        myPlayer.removeCard(normalCard);
        myPlayer.removeCard(specialCard);

        cardCount = 0;
        for (UnoCard card: myPlayer.getCardsIterator()) {
            cardCount += 1;
        }
        assertEquals(0, cardCount);
    }
}
