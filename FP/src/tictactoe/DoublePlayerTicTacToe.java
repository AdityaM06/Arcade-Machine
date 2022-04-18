package tictactoe;

//Imports
import base.*;

//Double player tic tac toe game class
public class DoublePlayerTicTacToe extends SimpleGame implements Playable {
    //Initializing
    char[][] gameBoard = new char[4][4];

    //Constants and variables
    final char emptySpace = '-';
    boolean playerOneTurn = true;
    boolean gameEnded = false;
    char playerSymbol;
    int userRow, userColumn;

    //Constructor
    public DoublePlayerTicTacToe() {
        super(new DoublePlayerTicTacToeOutput());

        //Setting up the game board
        for(int i = 0; i < 4; i++) {
            //Column Number
            gameBoard[0][i] = (char) (i + '0');
            for(int j = 0; j < 4; j++) {
                //Row Number
                gameBoard[j][0] = (char) (j + '0');
                //Setting each blank spot as -
                gameBoard[i][j] = emptySpace;
            }
        }
        //Setting the top corner to a space
        gameBoard[0][0] = ' ';
    }

    //Method to draw the gameboard
    public void drawBoard(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(gameBoard[i][j]);
            }
            //Making sure each row is on a different line
            System.out.println();
        }
    }

    //Method to check if a player won
    public void checkWin(){
        //Check each row
        for(int i = 1; i < 4; i++) {
            if(gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][2] == gameBoard[i][3] && gameBoard[i][1] != emptySpace) {
                gameEnded = true;
                System.out.println("Game ended");
            }
        }

        //Check each column
        for(int j = 1; j < 4; j++) {
            if(gameBoard[1][j] == gameBoard[2][j] && gameBoard[2][j] == gameBoard[3][j] && gameBoard[1][j] != emptySpace) {
                gameEnded = true;
                System.out.println("Game ended");
            }
        }

        //Check the diagonals
        if(gameBoard[1][1] == gameBoard[2][2] && gameBoard[3][3] == gameBoard[2][2] && gameBoard[1][1] != emptySpace) {
            gameEnded = true;
            System.out.println("Game ended");
        }
        if(gameBoard[3][1] == gameBoard[2][2] && gameBoard[2][2] ==  gameBoard[1][3] && gameBoard[3][1] != emptySpace) {
            gameEnded = true;
            System.out.println("Game ended");
        }
    }

    //Method to check if the board is full
    public boolean boardFull(){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //Going through every element and checking for a '-'
                if(gameBoard[i][j] == emptySpace) {
                    return false;
                }
            }
        }
        //Board is full and the game is a tie
        gameEnded = true;
        System.out.println(ConsoleColour.YELLOW + "Tie!" + ConsoleColour.RESET);
        return true;
    }

    //Main game code
    @Override
    public void play(){
        super.play();

        //Drawing the initial board
        drawBoard();

        //Game loop
        while (!gameEnded){
            //Setting the players turns
            if (playerOneTurn){
                playerSymbol = 'X';
            } else {
                playerSymbol = 'O';
            }

            //Inputting the players move
            System.out.println("Player " + playerSymbol);
            userColumn = InputHandler.getIntInput("Please enter which column number you want to play on: ");
            userRow = InputHandler.getIntInput("Please enter which row number you want to play on: ");

            //Making sure the player move is valid
            while (userRow < 1 || userRow > 3 || userColumn < 1 || userColumn > 3 ||
                    gameBoard[userRow][userColumn] != emptySpace){

                //Printing error message
                System.out.println(ConsoleColour.RED + "Those are invalid inputs, please enter row and column " +
                        "numbers between 1-3 and make sure that area isn't already taken: " + ConsoleColour.RESET);

                //Inputting user row and column again
                userColumn = InputHandler.getIntInput("Please enter which column number you want to play on: ");
                userRow = InputHandler.getIntInput("Please enter which row number you want to play on: ");
            }

            //Updating the game board and drawing it
            gameBoard[userRow][userColumn] = playerSymbol;
            drawBoard();

            //Switching the turn
            playerOneTurn = !playerOneTurn;

            //Checking for a win or if the gameboard is full
            boardFull();
            checkWin();
        }
        //Method that asks user to go again
        goAgain();
    }
}
