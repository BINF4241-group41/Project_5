# Part1

1. I decided to Test the Game class because it's the class 'organizer' which manage the entire project.
First of all I used @beforeAll to create the object that i need in the test and then I start to implement the test method. The first I want to test is the gamebaord components Therefore I used the "assertEquals" method to verify it.
Second step I tested the gameboard size and try to get a buffer overflow, also in this method I used "assertEquals" to check it.
Third step I put the input of the dice I checked if something happen where the input grown. In this case if there is problem the Exeception will catch and manage.
In the end I used @afterAll to delocate the object that I used in my test.
2. I generate the javadoc with the comment in the code and afterwards with the auto-generated plug in from Eclipse.
3. I can't find out any bug because most of the code is 'getter' and 'setter' thus it's pretty difficult to find something wrong. I try to find out a bug in 'Game' class but I don't find anything.