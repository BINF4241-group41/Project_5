package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests the ReverseCard class.
 */
public class ReverseCardTest {

    UnoGame game;


    @BeforeEach
    void setUpGame() {
        game = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Happy path test for initialization of a Reverse card.
     */
    @Test
    void testSuccessfulInitialization() {
        ReverseCard card = new ReverseCard(Color.Green);
        assertNotNull(card);
        assertTrue(card.getColor() == Color.Green);
    }

    /**
     * Tests whether the constructor of ReverseCard throws
     * an IllegalArgumentException when color is invalid.
     */
    @Test
    void testInvalidInitializationArguments() {
        try {
            ReverseCard card = new ReverseCard(Color.Wild);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected when initializing SkipCard with invalid color.");
    }

    /**
     * Tests the toString() method.
     */
    @Test
    void testToString() {
        ReverseCard card = new ReverseCard(Color.Red);
        assertEquals("RedReverse", card.toString());
    }

    /**
     * Test if the matching with a normal card works
     * correctly (matches by color).
     */
    @Test
    void testCanBePlayedNormal() {
        ReverseCard reverseCard = new ReverseCard(Color.Green);
        NormalCard normalComparisonCard1 = new NormalCard(Color.Green, 7);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Red, 3);
        assertTrue(reverseCard.canBePlayed(normalComparisonCard1));
        assertFalse(reverseCard.canBePlayed(normalComparisonCard2));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color/type).
     */
    @Test
    void testCanBePlayedSpecial() {
        ReverseCard reverseCard = new ReverseCard(Color.Blue);
        ReverseCard specialComparisonCard2 = new ReverseCard(Color.Yellow);
        SkipCard specialComparisonCard1 = new SkipCard(Color.Red);
        WildCard specialComparisonCard3 = new WildCard();
        assertTrue(reverseCard.canBePlayed(specialComparisonCard2));
        assertFalse(reverseCard.canBePlayed(specialComparisonCard1));
        assertTrue(reverseCard.canBePlayed(specialComparisonCard3));
        specialComparisonCard3.chooseColor(Color.Blue);
        assertTrue(reverseCard.canBePlayed(specialComparisonCard3));
    }

    /**
     * Test if the action is correctly executed
     * (the direction gets reversed).
     */
    @Test
    void testAction() {
        ReverseCard reverseCard = new ReverseCard(Color.Green);

        Player currentPlayer = game.currentPlayer();
        Player nextPlayer = game.nextPlayer();

        reverseCard.executeAction(game);

        assertEquals(game.currentPlayer(), currentPlayer);
        assertNotEquals(game.nextPlayer(), nextPlayer);
        assertEquals("p3", game.nextPlayer().getName());
    }
}
