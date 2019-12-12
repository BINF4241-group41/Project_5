package test;

import main.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Test the class NormalCard.
 */

class NormalCardTest {

    /**
    * Test whether normal initialization works correctly.
     */
    @Test
    void testSuccessfulInitialization() {
        NormalCard card1 = new NormalCard(Color.Red, 7);
        NormalCard card2 = new NormalCard(Color.Yellow, 0);
        assertNotNull(card1);
        assertNotNull(card2);
        assertTrue(card1.getColor() == Color.Red && card1.getNumber() == 7);
        assertTrue(card2.getColor() == Color.Yellow && card1.getNumber() == 0);
    }

    /**
     * Test whether the constructor of NormalCard throws
     * an IllegalArgumentException when color/number is invalid.
     */
    @Test
    void testInvalidInitializationArguments() {
        try {
            NormalCard card1 = new NormalCard(Color.Red, 13);
            NormalCard card2 = new NormalCard(Color.Red, -1);
            NormalCard card3 = new NormalCard(Color.Wild, 2);
            NormalCard card4 = new NormalCard(Color.Wild, -1);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail("IllegalArgumentException expected when initializing NormalCard with invalid number/color.");
    }

    /**
     * Test if the matching with a normal card works
     * correctly (matches by color/number).
     */
    @Test
    void testCanBePlayedNormal() {
        NormalCard normalCard1 = new NormalCard(Color.Red, 2);
        NormalCard normalComparisonCard1 = new NormalCard(Color.Red, 9);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Yellow, 2);
        NormalCard normalComparisonCard3 = new NormalCard(Color.Blue, 1);
        assertTrue(normalCard1.canBePlayed(normalComparisonCard1));
        assertTrue(normalCard1.canBePlayed(normalComparisonCard2));
        assertFalse(normalCard1.canBePlayed(normalComparisonCard3));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color).
     */
    @Test
    void testCanBePlayedSpecial() {
        NormalCard normalCard = new NormalCard(Color.Red, 2);
        SkipCard specialComparisonCard1 = new SkipCard(Color.Red);
        DrawTwoCard specialComparisonCard2 = new DrawTwoCard(Color.Blue);
        WildCard specialComparisonCard3 = new WildCard();
        assertTrue(normalCard.canBePlayed(specialComparisonCard1));
        assertFalse(normalCard.canBePlayed(specialComparisonCard2));
        assertTrue(normalCard.canBePlayed(specialComparisonCard3));
        specialComparisonCard3.chooseColor(Color.Red);
        assertTrue(normalCard.canBePlayed(specialComparisonCard3));
    }

    /**
     * Test the toString() method.
     */
    @Test
    void testToString() {
        NormalCard card1 = new NormalCard(Color.Blue, 0);
        NormalCard card2 = new NormalCard(Color.Green, 9);
        assertEquals("Blue0", card1.toString());
        assertEquals("Green9", card2.toString());
    }
}