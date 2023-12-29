# Command Line Wordle

## Description
This is a Java-based implementation of the popular Wordle game, designed to be played in the console. It's an exercise in writing Java classes and creating a modular and scalable program. The game follows the classic Wordle mechanics with a command-line twist.  
*Developer: Boris He*   
*Date Published: 2/7/23*

## How to Play
- The game selects a secret word from a loaded dictionary, based on a configured word length.
- Players guess the secret word via the command line.
- After each guess, the game provides feedback: correct letters in the right position (green), correct letters in the wrong position (yellow), and incorrect letters (absent).
- Players have a limited number of guesses to find the secret word. Running out of guesses means losing the game.
- All guesses can be reviewed by entering the `[history]` command.
- The game can be played in a standard or testing mode, as defined in the `GameConfiguration` file.

## Game Configuration
The `GameConfiguration` file allows customization of:
- Length of the secret word.
- Number of guesses available.
- Testing mode, which displays the secret word for debugging purposes.

## Starting the Game
To start the game, run the main program class. You'll be greeted with:

`Hello! Welcome to Wordle.
Do you want to play a new game? (y/n)`

Respond with `y` to start a new game or `n` to exit.

## Requirements
- Java 8 or higher.

Enjoy testing your word-guessing skills right in your Java console with this Wordle game!

## Sample Run

Hello! Welcome to Wordle.  
Do you want to play a new game? (y/n)  
y  
Enter your guess:  
goose  
G__  
You have 5 guess(es) remaining.  
Enter your guess:  
attic  
Y__  
You have 4 guess(es) remaining.  
Enter your guess:  
penne  
G  
You have 3 guess(es) remaining.  
Enter your guess:  
[history]  
goose -> G  
attic -> Y__  
penne -> __G  
Enter your guess:  
supercalifragilisticexpialidocious  
This word has an incorrect length. Please try again.  
Enter your guess:  
abcde  
This word is not in the dictionary. Please try again.  
Enter your guess:  
mount  
GGGGG  
Congratulations! You have guessed the word correctly.  
Do you want to play a new game? (y/n)  
y  
Enter your guess:  
[history]  
Enter your guess:  
goose  
YY  
You have 5 guess(es) remaining.  
Enter your guess:  
attic  
Y_  
You have 4 guess(es) remaining.  
Enter your guess:  
penne  
Y__  
You have 3 guess(es) remaining.  
Enter your guess:  
mount  

You have 2 guess(es) remaining.  
Enter your guess:  
crate  
YY_Y  
You have 1 guess(es) remaining.  
shoot  
Y___  
You have run out of guesses.  
The correct word was "laser".  
Do you want to play a new game? (y/n)  
n
