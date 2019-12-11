package test;

import main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SkipCardTest {

    UnoGame game;


    @BeforeAll
    void setUpGame() {
        game = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Happy path test for initialization of a Skip card.
     */
    @Test
    void testSuccessfulInitialization() {
        SkipCard card = new SkipCard(Color.Green);
        assertNotNull(card);
        assertTrue(card.getColor() == Color.Green);
    }

    /**
     * Tests whether the constructor of SkipCard throws
     * an IllegalArgumentException when color is invalid.
     */
    @Test
    void testInvalidInitializationArguments() {
        try {
            SkipCard card = new SkipCard(Color.Wild);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected when initializing NormalCard with invalid color.");
    }

    /**
     * Tests the toString() method.
     */
    @Test
    void testToString() {
        SkipCard card = new SkipCard(Color.Red);
        assertEquals(card.toString(), "RedSkip");
    }

    /**
     * Test if the matching with a normal card works
     * correctly (matches by color).
     */
    @Test
    void testCanBePlayedNormal() {
        SkipCard skipCard = new SkipCard(Color.Green);
        NormalCard normalComparisonCard1 = new NormalCard(Color.Green, 7);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Red, 3);
        assertTrue(skipCard.canBePlayed(normalComparisonCard1));
        assertFalse(skipCard.canBePlayed(normalComparisonCard2));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color/type).
     */
    @Test
    void testCanBePlayedSpecial() {
        SkipCard skipCard = new SkipCard(Color.Green);
        SkipCard specialComparisonCard1 = new SkipCard(Color.Red);
        ReverseCard specialComparisonCard2 = new ReverseCard(Color.Yellow);
        WildCard specialComparisonCard3 = new WildCard();
        assertTrue(skipCard.canBePlayed(specialComparisonCard1));
        assertFalse(skipCard.canBePlayed(specialComparisonCard2));
        assertFalse(skipCard.canBePlayed(specialComparisonCard3));
        specialComparisonCard3.chooseColor(Color.Green);
        assertTrue(skipCard.canBePlayed(specialComparisonCard3));
    }

    /**
     * Test if the action is correctly executed
     * (the next player gets skipped).
     */
    @Test
    void testAction() {
        SkipCard skipCard = new SkipCard(Color.Green);

        Player currentPlayer = game.currentPlayer();
        Player nextPlayer = game.nextPlayer();

        skipCard.executeAction(game);

        assertEquals(currentPlayer, game.currentPlayer());
        assertNotEquals(nextPlayer, game.nextPlayer());
    }
}
