package base;

import base.Playable;

//Class to store game names and create a new game using the GameFactory class
public class Game {
    //Constants for game names in the GameFactory class
    public final static String S_TTT_CASE = "single player tic tac toe";
    public final static String S_TTT_NUM_CASE = "1";

    public final static String D_TTT_CASE = "double player tic tac toe";
    public final static String D_TTT_NUM_CASE = "2";

    public final static String RPC_CASE = "rock paper scissors";
    public final static String RPC_NUM_CASE = "3";

    public final static String HANGMAN_CASE = "hangman";
    public final static String HANGMAN_NUM_CASE = "4";

    public final static String QUIT = "q";

    //Method to play the game
    public void playGame(String GameType){
        //Initializing the game the user wants to play
        Playable game = GameFactory.createGame(GameType);
        //Playing that game
        game.play();
    }

}
