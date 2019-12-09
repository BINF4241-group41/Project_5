# Part 1

1. I decided to Test the Game class because it's the class 'organizer' which manage the entire project.
First of all I used @beforeAll to create the object that i need in the test and then I start to implement the test method. The first I want to test is the gamebaord components Therefore, I used the "assertEquals" method to verify it.
Second step I tested the gameboard size and try to get a buffer overflow, also in this method I used "assertEquals" to check it.
Third step I put the input of the dice I checked if something happen where the input grown. In this case if there is a problem the Exception will catch and manage.
In the end, I used @afterAll to deallocate the object that I used in my test.
2. I generate the javadoc with the comment in the code and afterwards with the auto-generated plug in for Eclipse.
3. I can't find out any bug because most of the code is 'getter' and 'setter' thus it's pretty difficult to find something wrong. I try to find out a bug in 'Game' class, but I don't find anything.

# PART 2

1. First bug that I found out is in the method "public List<Position> getOpenPositions()", Here, there is a double for cycles, but the internal one starts from '1' instead from '0'. I figured out that in our test class we 
instantiate the gameboard from 0 to 2. But when you get all Position we receive just a piece of the 'table' Because we never get column '0'.
2. the second bug that I found out is in the method  "public boolean mark(int row, int col,TicTacToeGameState.Player player)", The returns are inverted because when there is a Player in our box the return should be false and when the box is free, then you can add the player and return true.

# PART 3

1a.
 
Setup:
- "Enter the number of players.": accepts numbers 2-10.
- "Enter the name of player n." (0<n is the number of the current player, 1 is dealer): accepts any String as input.
- "Enter the number of rounds won needed to win game.": accepts any positive integer.

Inputs have to be of the following form:
- "ColorNumber" (e.g. Yellow8) for normal cards.
- "ColorSkip"/"ColorReverse"/"ColorDrawTwo" (e.g. GreenSkip) for special cards where color is fixed.
- "Wild"/"WildDrawFour" when the card has no fixed color.
- To draw a new card, enter "!Draw".
- To select the color (if possible), enter "!Color" (e.g. !Red).
- If it is the 2nd last card that is played, !UNO can be entered.
- If the current player wants to finish thier turn, he has to enter "!Finish".
- If the previous player has not entered !UNO after playing their 2nd last card, !UNO can be entered before anything else to catch him.

End:
- If the game has ended, it won't react anymore.


1b.

- If the input is a valid card, play it.
- If the input is a valid command (!Command), execute it.
- If the input is invalid (malformed or wrong input), return error String (see below) and wait for next input.

1c.


- If the input is recognized but invalid (e.g. Yellow8 when the top card is Green6), return String "Unable to do this action! Please enter other action.".
- If the input is malformed, return String "Input not recognized! Please enter another action.".
- After a round is finished, return String "Current player: playerName. Top card: topCard. Available cards: card1, card2, ...". The cards are represented similar to the expected input (wildcards are of the form NameColor, with color being the selected color).
- If a player has no cards left, return String "Player playerName has won the round
- If the round ends, return "Player playerName has finished the round! Resetting game!".
- If one player reaches the number of rounds won needed to win the game, return String "Player playerName has won the game! This game is finished.".