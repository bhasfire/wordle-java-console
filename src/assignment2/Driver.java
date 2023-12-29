package assignment2;
import java.util.Scanner;

public class Driver {


    public void start(GameConfiguration config) {
        // TODO: complete this method
        // We will call this method from our JUnit test cases.
        Scanner in = new Scanner(System.in);

        printIntro();
        while(checkStart(in) == true){
            Game newGame = new Game(config, in);
            newGame.runGame();
            System.out.println("Do you want to play a new game? (y/n)");
        }
    }

    public void start_hardmode(GameConfiguration config) {
        // TODO: complete this method for extra credit
        // We will call this method from our JUnit test cases.
    }

    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.
        Driver d = new Driver();
        GameConfiguration g = new GameConfiguration(5, 6,false);
        d.start(g);
    }

    public static boolean checkStart(Scanner in){
        boolean ret = false;
        String check = "";
        while(!(check.equalsIgnoreCase("y") || check.equalsIgnoreCase("n"))){
            check = in.nextLine();
            if(check.equalsIgnoreCase("y")){
                ret = true;
            }
            else if(check.equalsIgnoreCase("n")){
                ret = false;
            }else{
                System.out.println("Do you want to play a new game? (y/n)");
            }
        }
        return ret;
    }

     static void printIntro(){
        System.out.println("Hello! Welcome to Wordle.");
        System.out.println("Do you want to play a new game? (y/n)");
    }

}
