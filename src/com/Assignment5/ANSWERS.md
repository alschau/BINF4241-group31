

#Assignment 5

##Part 1

1.
- DiceTest tests the Dice method, the output should be an integer between 1 and 6.
- LadderFieldTest/SnakeFieldTest/NormalFieldTest tests all getter methods. 
- PlayerTest tests all getter/setter methods of Player.
- The MainTest class tests multiple methods from the Main class, bc our Main method wasn't 
    structured very well we altered the class a little bit in order to test at least something
    (as discussed during your coffee break :) )
    
    We tested the amount of players and fields allowed in the game.
    The amount of players should be between 2 and 4 so we used the fail approach to test if 
    the given user input is lower than 2 or higher than 4. If the input isn't an int it should fail as well.
    If the input is 2-4 it should not fail but rather give the same int back.
    
    The amount of fields was kind of similar as we tested again if the input is an int and 
    if it's under or equal to 9. In those cases we used the fail approach again.
    If the input is more than 9 it should be accepted and the output needs to be equal to the input.
    
2. Javadoc comments are before each classes/methods
3. Didn't change anything related to errors, but of course there are differences
   between the assignment 1 main class und that one we used now.

##Part 2

4 out of 10 Tests failed:

###Game Board Test

####markTwice

__What does it do?__
Check if we can set a mark (we can't if there already is a mark).
If the position is empty, we should set a mark there and return True
Else the position is blocked and we can't put a mark there. Then we should return false

__How did I fix it?__
The function should return true if we can set the player and false if we can't. 
(Rows 72 and 75: Swap true and false)


####getOpenPositions

__What does it do?__
First it sets a mark at 0,0. Then it adds all fields to a list that should be empty.
Then it compares this list with the one we get with the getOpenPositions method in the
board class.


__How did I fix it?__
The column must start at index 0 (row 100 in GameBoard).

####getOpenPositionsAll

__What does it do?__
It adds all positions to a Position list and checks if they are empty.
As the board should be empty (no marks set in the test), the test should return true

__How did I fix it?__
Fixing the getOpenPositions method it the GameBoard class (for the getOpenPositions 
test) also fixed this test. It failed because the index of the column (row 100 in code) 
was starting at 1 but should start at 0.

####markOnBoard

__What does it do?__
It checks if we can set a mark on the board. 
(Can we place a mark at 0,0? Is it in the range of the board?)

__How did I fix it?__
Fixing the mark method in the GameBoard class (for the markTwice test) also fixed this test. 
It failed in the beginning because we could not set a marker at all and it always stated 
that the position is not empty.

###Game State Test

####startingPlayerIsX

__What does it do?__
It checks if starting player is X. 

__How did I fix it?__
The starting player is set to X when we strat the game. So we only have to return the 
starting player variable.

####isOverWin

__What does it do?__
It checks if game is over. The game is over if one of the player wins (HasWin) or it's a draw. 

__How did I fix it?__
The method itself isn't wrong but one of the completesColumn / 
completesRow / completesDiagonal seems to be wrong.

####CompletesDiagonal

__What does it do?__
It checks if a player has completed a diagonal by checking if given player is the same as 
the one on position (1,1) and if that player also is in two opposit edges.

__How did I fix it?__
The coordinate (1,2) is wrong because it's not an edge. It should be (2,2).

####GetCurrentPlayer

__What does it do?__
Returns the player whose turn it is.

__How did I fix it?__
This method should only return the currentPlayer variable.

####SwitchPlayer

__What does it do?__
It checks if the turn changes between the players.

__How did I fix it?__
Fixed automatically after I fixed the GetCurrentPlayer test.





##Part 3
__Accepting inputs__

at first you should be able to enter the player names(which have no restrictions) and then start the game. the game will only start if there were between 2 and 10 inputs for the playersnames. 

to play any card the input should be "Cardcolor" + "cardsign"

the cardcolor input should be the first letter of the actual color (blue --> "b")

to skip or forfeit a turn the user should write "draw" which lets him automatically draw a card.

if the input is incorrect ro not accepted an error message will appear and the console will ask for a correct input again.

__Handling inputs__

the tests should focus ont he main frame and rules of the games, not syntax or other cosmetics. If the game and the players have been instantiated, the game begins. now if a players wants to play a card, it has to first check for correct color and sign input, then if the card is in his hands and lastly if it fits on the stack. furthermore it has to check if the card has any actions bounded to it (draw,reverse etc). If one of those arent possible it should return a matching errormessage. The amount of cards in the players hands should also be constantly checked to check if drawing was done correctly ( also caused by actionsccards) plus the drawstack has to be under constant surveillance so that it can be newly shuffled form the middlestack if empty. Name inputs are only accepted before the game has started, there is no possible way to join a game in progress.

The tests can completely ignore any cards of the middlestack and drawstack other than the topcards.
so the inputs should be strictly distinguished by accepting and nonaccepting and should yield an errormessage fitting to unaccepting input.

The game should output the current player and his hand every turn. The game will be running until someone wins.




