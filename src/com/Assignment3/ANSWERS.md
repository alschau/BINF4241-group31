Software Construction
Group 31

**Part 1**

For part 1 of the assignment, we chose to implement the Singleton and the Iterator Design Pattern. 

We used the Singleton pattern to make sure that only one instance of our Board class is created. To do so, we first had to set the constructor of the board class to private such that we can't access it from outside the class. Then we added the public class which creates a board class if no existed (static uniqueinstance == null) or returns the existing one if one already exists.

The second pattern we used is the Iterator. We decided to use it to iterate through the graveyards of player1 and player2 (both saved in board class). To do so, we first hat to create the Iterator Interface and our Grave_Iterator with the fuctions next() and hasNext(). Then we had to make our create_Iterator class (in the Board class) to be able to initialize/use it in the Game class. Finally we created our printing function in the Game class which first creates 2 iterators for the graveyards and then iterates through both.

Java Class diagram:


Sequence diagram
![sequence diagram assignment 3 1](https://user-images.githubusercontent.com/45588658/68469048-a2622380-0219-11ea-83ad-603464bff1f1.png)

**Part 2**

![sequence diagram assignment 3](https://user-images.githubusercontent.com/45588658/68402967-7c3a7600-017c-11ea-8294-d08d16e087c7.png)

**Part 3**

We decided to implement the archbishop and superqueen structure using an adapter since it made the most sense to us to use this example. Using the adapter we could simply use the precoded functionalities of the normal queen and bishop and add new functions to the "special figures".

**INPUT**:

We prompt the user twice for input per turn. Example:


[Player], choose a valid field of a figure 

b2

[Player], Enter the field where you want to move your figure: 

b4


