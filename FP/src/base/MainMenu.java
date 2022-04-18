package base;

//Imports
import base.*;

//Class to display the main menu
public class MainMenu {
    //Constants and variables
    public static String userInput;

    //Method to print a list of games
    public void listOfGames(){
        //Printing the list of available games
        System.out.println("\t1. Single Player Tic Tac Toe");
        System.out.println("\t2. Double Player Tic Tac Toe");
        System.out.println("\t3. Rock Paper Scissors");
        System.out.println("\t4. Hangman");
        System.out.println("Enter 'q' to quit the game");
    }

    //Method to greet the user when they first enter the program
    public void greetPlayer(){
        System.out.println("Welcome to the Arcade Machine, below is a list of available games to play");
        listOfGames();
    }

    //Method to get the user input and make sure it is a valid option
    public String getUserInput(){
        //Reading userInput
        userInput = InputHandler.getStringInput("Please type in the number or the title " +
                "(exactly as spelled above) of the game you want to play: ");

        //Making sure the user inputs a correct title or number
        while (GameFactory.createGame(userInput) == null){
            userInput = InputHandler.getStringInput("That was not a valid input, please " +
                    "enter either the title or line number above: ");
        }

        //Returning the input
        return userInput;
    }
}
