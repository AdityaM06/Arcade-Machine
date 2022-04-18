package tictactoe;

//Imports
import base.GameOutput;

//Class to handle outputs of Single Player Tic Tac Toe
public class SinglePlayerTicTacToeOutput implements GameOutput {
    //Message to greet the player
    @Override
    public String greetPlayer() {
        return "Welcome to Single Player Tic Tac Toe, where you will be playing tic tac toe" +
                " against a computer";
    }

    //Rules of the game
    @Override
    public String showRules() {
        return "To win, get a 3 in a row, either vertically, horizontally or diagonally" +
            "\nIf the board is full, the game is considered a tie";
    }

    //Input (Not useful in this situation since there are 2 input questions)
    @Override
    public String requestInput() {
        return null;
    }
}
