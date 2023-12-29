package assignment2;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<String> prevGuesses;
    List<String> replies;

    public History(){
        prevGuesses = new ArrayList<>();
        replies = new ArrayList<>();
    }

    public void printHistory(){
        for(int i = 0; i < prevGuesses.size(); i++){
            System.out.println(prevGuesses.get(i) + "->" +replies.get(i));
        }
        System.out.println("--------");
    }

    public void addToHistory(String prevGuesses, String replies){
        this.prevGuesses.add(prevGuesses);
        this.replies.add(replies);
    }

}
