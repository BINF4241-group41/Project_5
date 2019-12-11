package test;

import main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for the class WildDrawFourCard.
 */
public class WildDrawFourCardTest {

    UnoGame game;


    @BeforeAll
    void setUpGame() {
        game = new UnoGame(new String[] {"p1", "p2", "p3"});
    }

    /**
     * Happy path test for initialization of a WildDrawFour card.
     */
    @Test
    void testSuccessfulInitialization() {
        WildDrawFourCard card = new WildDrawFourCard();
        assertNotNull(card);
        assertTrue(card.getColor() == Color.Wild);
    }

    /**
     * Tests the toString() method.
     */
    @Test
    void testToString() {
        WildDrawFourCard card = new WildDrawFourCard();
        assertEquals(card.toString(), "Wild");
    }

    /**
     * Tests the chooseColor() method (should fail for color wild).
     */
    @Test
    void testChooseColorWild() {
        WildDrawFourCard card = new WildDrawFourCard();
        assertEquals(card.toString(), "Wild");

        try {
            card.chooseColor(Color.Wild);
        }
        catch (IllegalArgumentException e) {
            return;
        }

        fail("IllegalArgumentException expected when setting WildDrawFourCard color to wild.");
    }

    /**
     * Tests the chooseColor() method (happy path).
     */
    @Test
    void testChooseColor() {
        WildDrawFourCard card = new WildDrawFourCard();
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
        WildDrawFourCard wildDrawFourCard = new WildDrawFourCard();
        NormalCard normalComparisonCard1 = new NormalCard(Color.Green, 7);
        NormalCard normalComparisonCard2 = new NormalCard(Color.Red, 3);
        assertTrue(wildDrawFourCard.canBePlayed(normalComparisonCard1));
        assertTrue(wildDrawFourCard.canBePlayed(normalComparisonCard2));
    }

    /**
     * Test if the matching with a special card works
     * correctly (matches by color/type).
     */
    @Test
    void testCanBePlayedSpecial() {
        WildDrawFourCard wildDrawFourCard = new WildDrawFourCard();
        ReverseCard specialComparisonCard1 = new ReverseCard(Color.Yellow);
        SkipCard specialComparisonCard2 = new SkipCard(Color.Green);
        assertTrue(wildDrawFourCard.canBePlayed(specialComparisonCard1));
        assertTrue(wildDrawFourCard.canBePlayed(specialComparisonCard2));
    }

    /**
     * Test if current player has 4 more cards.
     */
    @Test
    void testAction() {
        WildDrawFourCard wildDrawFourCard = new WildDrawFourCard();

        Iterable<UnoCard> iterable = game.currentPlayer().getCardsIterator();

        int numBefore = 0;
        for (UnoCard card: iterable) {
            numBefore += 1;
        }

        wildDrawFourCard.executeAction(game);

        iterable = game.currentPlayer().getCardsIterator();

        int numAfter = 0;
        for (UnoCard card: iterable) {
            numAfter += 1;
        }

        assertTrue(numBefore + 4 == numAfter);
    }
}
