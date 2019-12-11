package test;

import main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for the class WildCard.
 */
public class WildCardTest {


    UnoGame game;


    @BeforeAll
    void setUpGame() {
        game = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Happy path test for initialization of a Wild card.
     */
    @Test
    void testSuccessfulInitialization() {
        WildCard card = new WildCard();
        assertNotNull(card);
        assertTrue(card.getColor() == Color.Wild);
    }

    /**
     * Tests the toString() method.
     */
    @Test
    void testToString() {
        WildCard card = new WildCard();
        assertEquals(card.toString(), "Wild");
    }

    /**
     * Tests the chooseColor() method (should fail for color wild).
     */
    @Test
    void testChooseColorWild() {
        WildCard card = new WildCard();
        assertEquals(card.toString(), "Wild");

        try {
            card.chooseColor(Color.Wild);
        }
        catch (IllegalArgumentException e) {
            return;
        }

        fail("IllegalArgumentException expected when setting WildCard color to wild.");
    }

    /**
     * Tests the chooseColor() method (happy path).
     */
    @Test
    void testChooseColor() {
        WildCard card = new WildCard();
        assertEquals(card.toString(), "Wild");
        card.chooseColor(Color.Blue);
        assertEquals(card.toString(), "Blue");
    }

    /**
     * Test if the matching with a normal card works
     * correctly (matches any color).
     */
    @Test
    void testCanBePlayedNormal() {
        WildCard wildCard = new WildCard();
        NormalCard normalComparisonCard1 = new NormalCard(Color.Green, 7);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Red, 3);
        assertTrue(wildCard.canBePlayed(normalComparisonCard1));
        assertTrue(wildCard.canBePlayed(normalComparisonCard2));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color/type).
     */
    @Test
    void testCanBePlayedSpecial() {
        WildCard wildCard = new WildCard();
        ReverseCard specialComparisonCard1 = new ReverseCard(Color.Yellow);
        DrawTwoCard specialComparisonCard2 = new DrawTwoCard(Color.Green);
        assertTrue(wildCard.canBePlayed(specialComparisonCard1));
        assertTrue(wildCard.canBePlayed(specialComparisonCard2));
    }

    /**
     * Test if nothing happens.
     */
    @Test
    void testAction() {
        WildCard wildCard = new WildCard();

        Player currentPlayer = game.currentPlayer();
        Player nextPlayer = game.nextPlayer();

        Iterable<UnoCard> iterable = game.currentPlayer().getCardsIterator();

        int numBefore = 0;
        for (UnoCard card: iterable) {
            numBefore += 1;
        }

        wildCard.executeAction(game);

        assertEquals(currentPlayer, game.currentPlayer());
        assertEquals(nextPlayer, game.nextPlayer());

        iterable = game.currentPlayer().getCardsIterator();

        int numAfter = 0;
        for (UnoCard card: iterable) {
            numAfter += 1;
        }

        assertTrue(numBefore == numAfter);
    }
}
