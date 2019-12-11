package test;

import main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests the player class.
 */
public class PlayerTest {


    Player myPlayer;


    /**
     * Set up player for tests.
     */
    @BeforeAll
    void setUpPlayer() {
        myPlayer = new Player("PlayerName");
    }

    /**
     * Check for successful initialization (name, points and no cards).
     */
    @Test
    void initializationTest() {
        assertTrue(myPlayer.getName() == "PlayerName");
        assertEquals(myPlayer.getPoints(), 0);

        int cardCount = 0;
        for (UnoCard card: myPlayer.getCardsIterator()) {
            cardCount += 1;
        }
        assertEquals(cardCount, 0);
    }

    /**
     * Check that points get initialized and added correctly.
     */
    @Test
    void pointsTest() {
        assertEquals(myPlayer.getPoints(), 0);
        myPlayer.addPoints(10);
        assertEquals(myPlayer.getPoints(), 10);
    }

    /**
     * Check that negative point values get ignored.
     */
    @Test
    void pointsNegativeTest() {
        assertEquals(myPlayer.getPoints(), 0);
        myPlayer.addPoints(-10);
        assertEquals(myPlayer.getPoints(), 0);
    }

    /**
     * Test addition and removal of cards.
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
        assertEquals(cardCount, 2);

        myPlayer.removeCard(normalCard);
        myPlayer.removeCard(specialCard);

        cardCount = 0;
        for (UnoCard card: myPlayer.getCardsIterator()) {
            cardCount += 1;
        }
        assertEquals(cardCount, 0);
    }
}
