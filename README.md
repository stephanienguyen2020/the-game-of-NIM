# the-game-of-NIM
## Description

The Game of Nim is a well-known two-player game with a fascinating strategy. In this variant of the game, two players take turns removing marbles from a pile. On each turn, a player can choose to take between 1 and half of the marbles from the pile. The objective of the game is to force the opponent to take the last marble, making them the loser.

This program simulates the Game of Nim, where a computer plays against a human opponent. The game is set up as follows:

- The initial size of the pile is randomly generated between 10 and 100 marbles.
- The program randomly selects whether the computer or the human takes the first turn.
- Additionally, the computer can play in either "smart" or "stupid" mode, determined by a random selection.
    - In "stupid" mode, the computer takes a random legal value (between 1 and n/2) from the pile whenever it has a turn.
    - In "smart" mode, the computer calculates its moves to make the size of the pile one less than a power of two (e.g., 3, 7, 15, 31, or 63), except when the pile size is already one less than a power of two. In that case, it makes a random legal move.

It's important to note that the computer is nearly unbeatable in "smart" mode when it goes first, except in specific cases.

This program is inspired by problem P6.6 in the book "Big Java" by Cay S. Horstmann.

## Files
- `Computer.java`: Contains the implementation of the computer player's logic.
- `Game.java`: Implements the Game of Nim and manages player turns.
- `Human.java`: Represents the human player's actions and choices.

## How to Run

To run the Game of Nim program:
1. Compile the Java source files using a Java compiler (e.g., `javac`).
2. Execute the `Game` class, which acts as the entry point for the program.
3. Follow the on-screen prompts to play the Game of Nim against the computer.

Enjoy the game and have fun testing your strategic skills against the computer!

## Credits
- Program inspired by problem P6.6 in "Big Java" by Cay S. Horstmann.

If you encounter any issues or have suggestions for improvements, please feel free to open an issue on the GitHub repository.
