package base;

//Imports
import tictactoe.*;
import hangman.*;
import rockpaperscissors.*;
import static java.lang.System.exit;

public class GameFactory {
    //Method to check which game the user wants to play, and starting that game
    public static Playable createGame(String input){
        switch (input){
            case "single player tic tac toe":
            case "1":
                return new SinglePlayerTicTacToe();
            case "double player tic tac toe":
            case "2":
                return new DoublePlayerTicTacToe();
            case "rock paper scissors":
            case "3":
                return new RockPaperScissors();
            case "hangman":
            case "4":
                return new Hangman();
            case "q":
                System.out.println("Goodbye!");
                InputHandler.closeInput();
                exit(0);

        }
        return null;
    }
}
