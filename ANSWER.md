# Part1

1. I decided to Test the Game class because it's the class 'organizer' which manage the entire project.
First of all I used @beforeAll to create the object that i need in the test and then I start to implement the test method. The first I want to test is the gamebaord components Therefore, I used the "assertEquals" method to verify it.
Second step I tested the gameboard size and try to get a buffer overflow, also in this method I used "assertEquals" to check it.
Third step I put the input of the dice I checked if something happen where the input grown. In this case if there is a problem the Exception will catch and manage.
In the end, I used @afterAll to deallocate the object that I used in my test.
2. I generate the javadoc with the comment in the code and afterwards with the auto-generated plug in for Eclipse.
3. I can't find out any bug because most of the code is 'getter' and 'setter' thus it's pretty difficult to find something wrong. I try to find out a bug in 'Game' class, but I don't find anything.

# PART2

1. First bug that I found out is in the method "public List<Position> getOpenPositions()", Here, there is a double for cycles, but the internal one starts from '1' instead from '0'. I figured out that in our test class we 
instantiate the gameboard from 0 to 2. But when you get all Position we receive just a piece of the 'table' Because we never get column '0'.
2. the second bug that I found out is in the method  "public boolean mark(int row, int col,TicTacToeGameState.Player player)", The returns are inverted because when there is a Player in our box the return should be false and when the box is free, then you can add the player and return true.