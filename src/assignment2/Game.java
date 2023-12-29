package assignment2;

import java.util.Scanner;

public class Game {
//TODO: Design a Game.java class to handle top-level gameplay
//You may add whatever constructor or methods you like
    History history;
    GameConfiguration gameConfig;
    String secretWord;
    Dictionary dictionary;
    Wordle wordle;
    Scanner in;

    /*
     * Game Constructor
     */
    public Game(GameConfiguration gConfigIn, Scanner string){
        in = string;
        gameConfig = new GameConfiguration(gConfigIn.wordLength, gConfigIn.numGuesses, gConfigIn.testMode);
        history = new History();

        //Dictionary initialization depends on wordLength
        if(gameConfig.wordLength == 4){
            dictionary = new Dictionary("4_letter_words.txt");
        }
        if(gameConfig.wordLength == 5){
            dictionary = new Dictionary("5_letter_words.txt");
        }
        if(gameConfig.wordLength == 6){
            dictionary = new Dictionary("6_letter_words.txt");
        }
        secretWord = dictionary.getRandomWord();
        //secretWord = "laser"; //FOR TESTING ONLY
    }

    /*
     * High-level Runner of Wordle game
     */
    public void runGame(){
        String guessInput = "0";
        String response = "0";
        int numGuess = gameConfig.numGuesses;

        if (gameConfig.testMode) {                      //print answer if testMode is enabled
            System.out.println(secretWord);
        }

        while(numGuess > 0){
            System.out.println("Enter your guess: ");
            guessInput = in.nextLine();
            if(isValidGuess(guessInput) == 1) {         //checks if input is acceptable
                wordle = new Wordle(guessInput, secretWord, response);
                numGuess--;
                if(wordle.isWinner(guessInput)){        //breaks out of for loop if user guesses correctly
                    break;
                }
                wordle.feedback();                      //wordle function to provide feedback on guess
                response = wordle.lastHint;             //variable needed to save previous given hint + update History

                if(numGuess != 0) {
                    System.out.println("You have " + numGuess + " guess(es) remaining.");
                }
                if(!(guessInput.equals("0"))){
                    history.addToHistory(guessInput, response);
                }
            }
        }

        if(wordle.isWinner(guessInput)){           //if user guesses correctly, output 'G' wordLength times and congratulate
            for(int i = 0; i<secretWord.length(); i++){
                System.out.print("G");
            }
            System.out.println();
            System.out.println("Congratulations! You have guessed the word correctly.");
        }
        else{           //if user loses game, print correct word, and ask if they want to continue with a new game
            System.out.println("You have run out of guesses.");
            System.out.println("The correct word was " + "\""+secretWord+"\".");
        }
    }
    /*
     * The function isValidGuess determines whether the input is acceptable
     */
    public int isValidGuess(String guess){
        if(guess.equals("[history]")){
            history.printHistory();
            return 0;
        }
        else if(guess.length() != gameConfig.wordLength ){
            System.out.println("This word has an incorrect length. Please try again.");
            return -1;
        }
        else if(!dictionary.containsWord(guess)){
            System.out.println("This word is not in the dictionary. Please try again.");
            return -1;
        }
        else{
            return 1;   //1 means the user input is valid
        }
        //need to ensure valid guess - is it in dictionary? Is word length corerect? etc...
        //if the guess is a history, call printHistory function.
        //Create Wordle object to compare?
    }

}
