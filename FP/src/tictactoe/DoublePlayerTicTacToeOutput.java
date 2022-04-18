package tictactoe;

//Imports
import base.*;

//Class to handle Double Player Tic Tac Toe outputs
public class DoublePlayerTicTacToeOutput implements GameOutput {
    //Message to greet the player
    @Override
    public String greetPlayer() {
        return "Welcome to Double Player Tic Tac Toe, where you will play against one of" +
                " your friends";
    }

    //Rules of the game
    @Override
    public String showRules() {
        return "To win, get a 3 in a row, either vertically, horizontally or diagonally" +
                "\nIf the board is full, the game is considered a tie";
    }

    //This method isn't in use in this game, but it is required by the interface
    @Override
    public String requestInput() {
        return null;
    }

}
