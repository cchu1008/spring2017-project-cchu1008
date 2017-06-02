## Final Software Architecture

##### Model-View-Controller Architecture

![MVC Class Diagram](images/ClassDiagram.png)

##### Abstract Classes

![Pieces UML Diagram](images/PiecesUML.png)

## Design Patterns

* Strategy
    * Allows for one concrete object to have the option of many different functionalities
    * Different pieces can move differently
* Observer
    * Allows objects to update themselves and then notify their subscribers (Listeners in this case) about the change.
    * Subscribers can use the updated information to perform their own functionalities
* State
    * Allows for different game states
    * States cycle when triggered (by mouse clicks, key presses, and events [winning the game])

## Highlights

My favorite implementation was in showing the valid moves for each piece when the piece was moused over.

![Valid Moves]()

The timing was tricky because if you handle the function primarily in the render function of the Play state, the highlighted squares will flicker. The tiles themselves had to work together with the GameDriver and Play state to create the illusion of being 'moused over' when they were a part of the validMoves array.

## What I Learned

I learned a lot about the different design patterns you can use to make a program. My eyes were opened to Enumerators, which I used to link my pieces to their images, and to the State Pattern which can be used with any automated system (including finite state machines).

Screenshots of project stages
