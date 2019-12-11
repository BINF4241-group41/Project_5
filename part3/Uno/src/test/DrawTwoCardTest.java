package test;

import main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests the class DrawTwoCard for its specific implementations.
 */
class DrawTwoCardTest {


    UnoGame game;


    @BeforeAll
    void setUpGame() {
        game = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Happy path test for initialization of a DrawTwo card.
     */
    @Test
    void testSuccessfulInitialization() {
        DrawTwoCard card = new DrawTwoCard(Color.Blue);
        assertNotNull(card);
        assertTrue(card.getColor() == Color.Blue);
    }

    /**
     * Tests whether the constructor of DrawTwoCard throws
     * an IllegalArgumentException when color is invalid.
     */
    @Test
    void testInvalidInitializationArguments() {
        try {
            DrawTwoCard card = new DrawTwoCard(Color.Wild);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected when initializing DrawTwoCard with invalid color.");
    }

    /**
     * Tests the toString() method.
     */
    @Test
    void testToString() {
        DrawTwoCard card = new DrawTwoCard(Color.Red);
        assertEquals(card.toString(), "RedDrawTwo");
    }

    /**
     * Test if the matching with a normal card works
     * correctly (matches by color).
     */
    @Test
    void testCanBePlayedNormal() {
        DrawTwoCard drawTwoCard = new DrawTwoCard(Color.Green);
        NormalCard normalComparisonCard1 = new NormalCard(Color.Green, 2);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Blue, 1);
        assertTrue(drawTwoCard.canBePlayed(normalComparisonCard1));
        assertFalse(drawTwoCard.canBePlayed(normalComparisonCard2));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color/type).
     */
    @Test
    void testCanBePlayedSpecial() {
        DrawTwoCard drawTwoCard = new DrawTwoCard(Color.Green);
        SkipCard specialComparisonCard1 = new SkipCard(Color.Green);
        DrawTwoCard specialComparisonCard2 = new DrawTwoCard(Color.Blue);
        WildCard specialComparisonCard3 = new WildCard();
        assertTrue(drawTwoCard.canBePlayed(specialComparisonCard1));
        assertTrue(drawTwoCard.canBePlayed(specialComparisonCard2));
        assertTrue(drawTwoCard.canBePlayed(specialComparisonCard3));
        specialComparisonCard3.chooseColor(Color.Green);
        assertTrue(drawTwoCard.canBePlayed(specialComparisonCard3));
    }

    /**
     * Test if the action is correctly executed
     * (two cards are added to the current player).
     */
    @Test
    void testAction() {
        DrawTwoCard drawTwoCard = new DrawTwoCard(Color.Green);

        int numBefore = 0;
        for (UnoCard card: game.currentPlayer().getCardsIterator()) {
            numBefore += 1;
        }

        drawTwoCard.executeAction(game);

        int numAfter = 0;
        for (UnoCard card: game.currentPlayer().getCardsIterator()) {
            numAfter += 1;
        }

        assertTrue(numBefore + 2 == numAfter);
    }
}