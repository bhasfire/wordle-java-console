package assignment2;

import java.util.HashSet;
import java.util.Set;

public class Wordle {
    String guess;
    String secretWord;
    String lastHint;

    /*
     * Constructor for Wordle object - each new guess is a new Wordle Object
     */
    public Wordle(String guess, String secretWord, String lastHint){
        this.guess = guess;
        this.secretWord = secretWord;
        this.lastHint = lastHint;
    }

    /*
     * Wordle function to provide feedback on user guess
     */
    public void feedback(){
        String hint = "";
        Set repeat = new HashSet();     //hashSet to determine if there's a repeating character (Sets are Unique)
        char[] tempSecret = secretWord.toCharArray();
        char[] tempGuess = guess.toCharArray();
        char[] tempHint = new char[guess.length()];

        //first pass to add 'G' to correct spots
        for(int i = 0; i < tempGuess.length; i++){
            if(tempGuess[i] == tempSecret[i]){
                tempHint[i] = 'G';
                repeat.add(tempGuess[i]);
            }
            else if(tempHint[i] != 'G'){
                tempHint[i] = '_';
            }
        }

        //second pass to add 'Y' to correct spots
        for(int i = 0; i< tempGuess.length;i++){
            for(int j = 0; j<tempGuess.length; j++){
                if(tempGuess[i] == tempSecret[j] && tempHint[i] != 'G') {
                    if(!(repeat.contains(tempGuess[i]))){
                        tempHint[i] = 'Y';
                        repeat.add(tempGuess[i]);
                    }
                    else if(repeat.contains(tempGuess[i])){
                        repeat.remove(tempGuess[i]);
                    }
                }
            }
        }

        //toString for tempHint char array
        for (char c : tempHint) {
            hint += c;
        }
        lastHint = hint;
        System.out.println(hint);
    }

    /*
     * isWinner function to determine if user guesses correctly
     */
    public boolean isWinner(String guess){
        return guess.equals(secretWord);
    }

}
